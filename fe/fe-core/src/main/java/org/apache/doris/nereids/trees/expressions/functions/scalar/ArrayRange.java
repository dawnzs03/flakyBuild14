// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package org.apache.doris.nereids.trees.expressions.functions.scalar;

import org.apache.doris.catalog.FunctionSignature;
import org.apache.doris.nereids.trees.expressions.Expression;
import org.apache.doris.nereids.trees.expressions.functions.AlwaysNullable;
import org.apache.doris.nereids.trees.expressions.functions.ExplicitlyCastableSignature;
import org.apache.doris.nereids.trees.expressions.visitor.ExpressionVisitor;
import org.apache.doris.nereids.types.ArrayType;
import org.apache.doris.nereids.types.IntegerType;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * ScalarFunction 'array_range'. This class is generated by GenerateFunction.
 */
public class ArrayRange extends ScalarFunction
        implements ExplicitlyCastableSignature, AlwaysNullable {

    public static final List<FunctionSignature> SIGNATURES = ImmutableList.of(
            FunctionSignature.ret(ArrayType.of(IntegerType.INSTANCE)).args(IntegerType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(IntegerType.INSTANCE)).args(IntegerType.INSTANCE, IntegerType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(IntegerType.INSTANCE))
                    .args(IntegerType.INSTANCE, IntegerType.INSTANCE, IntegerType.INSTANCE)
    );

    /**
     * constructor with 1 argument.
     */
    public ArrayRange(Expression arg) {
        super("array_range", arg);
    }

    /**
     * constructor with 2 arguments.
     */
    public ArrayRange(Expression arg0, Expression arg1) {
        super("array_range", arg0, arg1);
    }

    /**
     * constructor with 3 arguments.
     */
    public ArrayRange(Expression arg0, Expression arg1, Expression arg2) {
        super("array_range", arg0, arg1, arg2);
    }

    /**
     * withChildren.
     */
    @Override
    public ArrayRange withChildren(List<Expression> children) {
        Preconditions.checkArgument(children.size() == 1
                || children.size() == 2
                || children.size() == 3);
        if (children.size() == 1) {
            return new ArrayRange(children.get(0));
        } else if (children.size() == 2) {
            return new ArrayRange(children.get(0), children.get(1));
        } else {
            return new ArrayRange(children.get(0), children.get(1), children.get(2));
        }
    }

    @Override
    public <R, C> R accept(ExpressionVisitor<R, C> visitor, C context) {
        return visitor.visitArrayRange(this, context);
    }

    @Override
    public List<FunctionSignature> getSignatures() {
        return SIGNATURES;
    }
}
