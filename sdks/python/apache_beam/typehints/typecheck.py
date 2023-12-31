#
# Licensed to the Apache Software Foundation (ASF) under one or more
# contributor license agreements.  See the NOTICE file distributed with
# this work for additional information regarding copyright ownership.
# The ASF licenses this file to You under the Apache License, Version 2.0
# (the "License"); you may not use this file except in compliance with
# the License.  You may obtain a copy of the License at
#
#    http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

"""Runtime type checking support.

For internal use only; no backwards-compatibility guarantees.
"""

# pytype: skip-file

import inspect
import sys
import types
from collections import abc

from apache_beam import pipeline
from apache_beam.pvalue import TaggedOutput
from apache_beam.transforms import core
from apache_beam.transforms.core import DoFn
from apache_beam.transforms.window import TimestampedValue
from apache_beam.transforms.window import WindowedValue
from apache_beam.typehints.decorators import GeneratorWrapper
from apache_beam.typehints.decorators import TypeCheckError
from apache_beam.typehints.decorators import _check_instance_type
from apache_beam.typehints.decorators import getcallargs_forhints
from apache_beam.typehints.typehints import CompositeTypeHintError
from apache_beam.typehints.typehints import SimpleTypeHintError
from apache_beam.typehints.typehints import check_constraint
from apache_beam.typehints.typehints import normalize


class AbstractDoFnWrapper(DoFn):
  """An abstract class to create wrapper around DoFn"""
  def __init__(self, dofn):
    super().__init__()
    self.dofn = dofn

  def _inspect_start_bundle(self):
    return self.dofn.get_function_arguments('start_bundle')

  def _inspect_process(self):
    return self.dofn.get_function_arguments('process')

  def _inspect_finish_bundle(self):
    return self.dofn.get_function_arguments('finish_bundle')

  def wrapper(self, method, args, kwargs):
    return method(*args, **kwargs)

  def setup(self):
    return self.dofn.setup()

  def start_bundle(self, *args, **kwargs):
    return self.wrapper(self.dofn.start_bundle, args, kwargs)

  def process(self, *args, **kwargs):
    return self.wrapper(self.dofn.process, args, kwargs)

  def finish_bundle(self, *args, **kwargs):
    return self.wrapper(self.dofn.finish_bundle, args, kwargs)

  def teardown(self):
    return self.dofn.teardown()


class OutputCheckWrapperDoFn(AbstractDoFnWrapper):
  """A DoFn that verifies against common errors in the output type."""
  def __init__(self, dofn, full_label):
    super().__init__(dofn)
    self.full_label = full_label

  def wrapper(self, method, args, kwargs):
    try:
      result = method(*args, **kwargs)
    except TypeCheckError as e:
      # TODO(BEAM-10710): Remove the 'ParDo' prefix for the label name
      error_msg = (
          'Runtime type violation detected within ParDo(%s): '
          '%s' % (self.full_label, e))
      _, _, tb = sys.exc_info()
      raise TypeCheckError(error_msg).with_traceback(tb)
    else:
      return self._check_type(result)

  @staticmethod
  def _check_type(output):
    if output is None:
      return output

    elif isinstance(output, (dict, bytes, str)):
      object_type = type(output).__name__
      raise TypeCheckError(
          'Returning a %s from a ParDo or FlatMap is '
          'discouraged. Please use list("%s") if you really '
          'want this behavior.' % (object_type, output))
    elif not isinstance(output, abc.Iterable):
      raise TypeCheckError(
          'FlatMap and ParDo must return an '
          'iterable. %s was returned instead.' % type(output))
    return output


class TypeCheckWrapperDoFn(AbstractDoFnWrapper):
  """A wrapper around a DoFn which performs type-checking of input and output.
  """
  def __init__(self, dofn, type_hints, label=None):
    super().__init__(dofn)
    self._process_fn = self.dofn._process_argspec_fn()
    if type_hints.input_types:
      input_args, input_kwargs = type_hints.input_types
      self._input_hints = getcallargs_forhints(
          self._process_fn, *input_args, **input_kwargs)
    else:
      self._input_hints = None
    # TODO(robertwb): Multi-output.
    self._output_type_hint = type_hints.simple_output_type(label)

  def wrapper(self, method, args, kwargs):
    result = method(*args, **kwargs)
    return self._type_check_result(result)

  def process(self, *args, **kwargs):
    if self._input_hints:
      actual_inputs = inspect.getcallargs(self._process_fn, *args, **kwargs)  # pylint: disable=deprecated-method
      for var, hint in self._input_hints.items():
        if hint is actual_inputs[var]:
          # self parameter
          continue
        _check_instance_type(hint, actual_inputs[var], var, True)
    return self._type_check_result(self.dofn.process(*args, **kwargs))

  def _type_check_result(self, transform_results):
    if self._output_type_hint is None or transform_results is None:
      return transform_results

    def type_check_output(o):
      if isinstance(o, TimestampedValue) and hasattr(o, "__orig_class__"):
        # when a typed TimestampedValue is set, check the value type
        x = o.value
        # per https://stackoverflow.com/questions/57706180/,
        # __orig_class__ is te safe way to obtain the actual type
        # from from Generic[T], supported since Python 3.5.3
        beam_type = normalize(o.__orig_class__.__args__[0])
        self.type_check(beam_type, x, is_input=False)
      else:
        # TODO(robertwb): Multi-output.
        x = o.value if isinstance(o, (TaggedOutput, WindowedValue)) else o

        self.type_check(self._output_type_hint, x, is_input=False)

    # If the return type is a generator, then we will need to interleave our
    # type-checking with its normal iteration so we don't deplete the
    # generator initially just by type-checking its yielded contents.
    if isinstance(transform_results, types.GeneratorType):
      return GeneratorWrapper(transform_results, type_check_output)
    for o in transform_results:
      type_check_output(o)
    return transform_results

  @staticmethod
  def type_check(type_constraint, datum, is_input):
    """Typecheck a PTransform related datum according to a type constraint.

    This function is used to optionally type-check either an input or an output
    to a PTransform.

    Args:
        type_constraint: An instance of a typehints.TypeContraint, one of the
          white-listed builtin Python types, or a custom user class.
        datum: An instance of a Python object.
        is_input: True if 'datum' is an input to a PTransform's DoFn. False
          otherwise.

    Raises:
      TypeError: If 'datum' fails to type-check according to 'type_constraint'.
    """
    datum_type = 'input' if is_input else 'output'

    try:
      check_constraint(type_constraint, datum)
    except CompositeTypeHintError as e:
      _, _, tb = sys.exc_info()
      raise TypeCheckError(e.args[0]).with_traceback(tb)
    except SimpleTypeHintError:
      error_msg = (
          "According to type-hint expected %s should be of type %s. "
          "Instead, received '%s', an instance of type %s." %
          (datum_type, type_constraint, datum, type(datum)))
      _, _, tb = sys.exc_info()
      raise TypeCheckError(error_msg).with_traceback(tb)


class TypeCheckCombineFn(core.CombineFn):
  """A wrapper around a CombineFn performing type-checking of input and output.
  """
  def __init__(self, combinefn, type_hints, label=None):
    self._combinefn = combinefn
    self._input_type_hint = type_hints.input_types
    self._output_type_hint = type_hints.simple_output_type(label)
    self._label = label

  def setup(self, *args, **kwargs):
    self._combinefn.setup(*args, **kwargs)

  def create_accumulator(self, *args, **kwargs):
    return self._combinefn.create_accumulator(*args, **kwargs)

  def add_input(self, accumulator, element, *args, **kwargs):
    if self._input_type_hint:
      try:
        _check_instance_type(
            self._input_type_hint[0][0].tuple_types[1],
            element,
            'element',
            True)
      except TypeCheckError as e:
        error_msg = (
            'Runtime type violation detected within %s: '
            '%s' % (self._label, e))
        _, _, tb = sys.exc_info()
        raise TypeCheckError(error_msg).with_traceback(tb)
    return self._combinefn.add_input(accumulator, element, *args, **kwargs)

  def merge_accumulators(self, accumulators, *args, **kwargs):
    return self._combinefn.merge_accumulators(accumulators, *args, **kwargs)

  def compact(self, accumulator, *args, **kwargs):
    return self._combinefn.compact(accumulator, *args, **kwargs)

  def extract_output(self, accumulator, *args, **kwargs):
    result = self._combinefn.extract_output(accumulator, *args, **kwargs)
    if self._output_type_hint:
      try:
        _check_instance_type(
            self._output_type_hint.tuple_types[1], result, None, True)
      except TypeCheckError as e:
        error_msg = (
            'Runtime type violation detected within %s: '
            '%s' % (self._label, e))
        _, _, tb = sys.exc_info()
        raise TypeCheckError(error_msg).with_traceback(tb)
    return result

  def teardown(self, *args, **kwargs):
    self._combinefn.teardown(*args, **kwargs)


class TypeCheckVisitor(pipeline.PipelineVisitor):

  _in_combine = False

  def enter_composite_transform(self, applied_transform):
    if isinstance(applied_transform.transform, core.CombinePerKey):
      self._in_combine = True
      self._wrapped_fn = applied_transform.transform.fn = TypeCheckCombineFn(
          applied_transform.transform.fn,
          applied_transform.transform.get_type_hints(),
          applied_transform.full_label)

  def leave_composite_transform(self, applied_transform):
    if isinstance(applied_transform.transform, core.CombinePerKey):
      self._in_combine = False

  def visit_transform(self, applied_transform):
    transform = applied_transform.transform
    if isinstance(transform, core.ParDo):
      if self._in_combine:
        if isinstance(transform.fn, core.CombineValuesDoFn):
          transform.fn.combinefn = self._wrapped_fn
      else:
        transform.fn = transform.dofn = OutputCheckWrapperDoFn(
            TypeCheckWrapperDoFn(
                transform.fn,
                transform.get_type_hints(),
                applied_transform.full_label),
            applied_transform.full_label)


class PerformanceTypeCheckVisitor(pipeline.PipelineVisitor):
  def visit_transform(self, applied_transform):
    transform = applied_transform.transform
    full_label = applied_transform.full_label

    # Store output type hints in current transform
    output_type_hints = self.get_output_type_hints(transform)
    if output_type_hints:
      transform._add_type_constraint_from_consumer(
          full_label, output_type_hints)

    # Store input type hints in producer transform
    input_type_hints = self.get_input_type_hints(transform)
    if input_type_hints and len(applied_transform.inputs):
      producer = applied_transform.inputs[0].producer
      if producer:
        producer.transform._add_type_constraint_from_consumer(
            full_label, input_type_hints)

  def get_input_type_hints(self, transform):
    type_hints = transform.get_type_hints()

    input_types = None
    if type_hints.input_types:
      normal_hints, kwarg_hints = type_hints.input_types
      if kwarg_hints:
        input_types = kwarg_hints
      if normal_hints:
        input_types = normal_hints

    parameter_name = 'Unknown Parameter'
    if hasattr(transform, 'fn'):
      try:
        argspec = inspect.getfullargspec(transform.fn._process_argspec_fn())
      except TypeError:
        # An unsupported callable was passed to getfullargspec
        pass
      else:
        if len(argspec.args):
          arg_index = 0
          if argspec.args[0] == 'self' and len(argspec.args) > 1:
            arg_index = 1
          parameter_name = argspec.args[arg_index]
          if isinstance(input_types, dict):
            input_types = (input_types[argspec.args[arg_index]], )

    if input_types and len(input_types):
      input_types = input_types[0]

    return parameter_name, input_types

  def get_output_type_hints(self, transform):
    type_hints = transform.get_type_hints()

    output_types = None
    if type_hints.output_types:
      normal_hints, kwarg_hints = type_hints.output_types
      if kwarg_hints:
        output_types = kwarg_hints
      if normal_hints:
        output_types = normal_hints

    if output_types and len(output_types):
      output_types = output_types[0]

    return None, output_types
