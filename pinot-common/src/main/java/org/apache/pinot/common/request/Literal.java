/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
/**
 * Autogenerated by Thrift Compiler (0.15.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.pinot.common.request;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.15.0)", date = "2023-08-31")
public class Literal extends org.apache.thrift.TUnion<Literal, Literal._Fields> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Literal");
  private static final org.apache.thrift.protocol.TField BOOL_VALUE_FIELD_DESC = new org.apache.thrift.protocol.TField("boolValue", org.apache.thrift.protocol.TType.BOOL, (short)1);
  private static final org.apache.thrift.protocol.TField BYTE_VALUE_FIELD_DESC = new org.apache.thrift.protocol.TField("byteValue", org.apache.thrift.protocol.TType.BYTE, (short)2);
  private static final org.apache.thrift.protocol.TField SHORT_VALUE_FIELD_DESC = new org.apache.thrift.protocol.TField("shortValue", org.apache.thrift.protocol.TType.I16, (short)3);
  private static final org.apache.thrift.protocol.TField INT_VALUE_FIELD_DESC = new org.apache.thrift.protocol.TField("intValue", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField LONG_VALUE_FIELD_DESC = new org.apache.thrift.protocol.TField("longValue", org.apache.thrift.protocol.TType.I64, (short)5);
  private static final org.apache.thrift.protocol.TField DOUBLE_VALUE_FIELD_DESC = new org.apache.thrift.protocol.TField("doubleValue", org.apache.thrift.protocol.TType.DOUBLE, (short)6);
  private static final org.apache.thrift.protocol.TField STRING_VALUE_FIELD_DESC = new org.apache.thrift.protocol.TField("stringValue", org.apache.thrift.protocol.TType.STRING, (short)7);
  private static final org.apache.thrift.protocol.TField BINARY_VALUE_FIELD_DESC = new org.apache.thrift.protocol.TField("binaryValue", org.apache.thrift.protocol.TType.STRING, (short)8);
  private static final org.apache.thrift.protocol.TField NULL_VALUE_FIELD_DESC = new org.apache.thrift.protocol.TField("nullValue", org.apache.thrift.protocol.TType.BOOL, (short)9);
  private static final org.apache.thrift.protocol.TField BIG_DECIMAL_VALUE_FIELD_DESC = new org.apache.thrift.protocol.TField("bigDecimalValue", org.apache.thrift.protocol.TType.STRING, (short)10);

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    BOOL_VALUE((short)1, "boolValue"),
    BYTE_VALUE((short)2, "byteValue"),
    SHORT_VALUE((short)3, "shortValue"),
    INT_VALUE((short)4, "intValue"),
    LONG_VALUE((short)5, "longValue"),
    DOUBLE_VALUE((short)6, "doubleValue"),
    STRING_VALUE((short)7, "stringValue"),
    BINARY_VALUE((short)8, "binaryValue"),
    NULL_VALUE((short)9, "nullValue"),
    BIG_DECIMAL_VALUE((short)10, "bigDecimalValue");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // BOOL_VALUE
          return BOOL_VALUE;
        case 2: // BYTE_VALUE
          return BYTE_VALUE;
        case 3: // SHORT_VALUE
          return SHORT_VALUE;
        case 4: // INT_VALUE
          return INT_VALUE;
        case 5: // LONG_VALUE
          return LONG_VALUE;
        case 6: // DOUBLE_VALUE
          return DOUBLE_VALUE;
        case 7: // STRING_VALUE
          return STRING_VALUE;
        case 8: // BINARY_VALUE
          return BINARY_VALUE;
        case 9: // NULL_VALUE
          return NULL_VALUE;
        case 10: // BIG_DECIMAL_VALUE
          return BIG_DECIMAL_VALUE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.BOOL_VALUE, new org.apache.thrift.meta_data.FieldMetaData("boolValue", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.BYTE_VALUE, new org.apache.thrift.meta_data.FieldMetaData("byteValue", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BYTE)));
    tmpMap.put(_Fields.SHORT_VALUE, new org.apache.thrift.meta_data.FieldMetaData("shortValue", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I16)));
    tmpMap.put(_Fields.INT_VALUE, new org.apache.thrift.meta_data.FieldMetaData("intValue", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.LONG_VALUE, new org.apache.thrift.meta_data.FieldMetaData("longValue", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.DOUBLE_VALUE, new org.apache.thrift.meta_data.FieldMetaData("doubleValue", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.STRING_VALUE, new org.apache.thrift.meta_data.FieldMetaData("stringValue", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.BINARY_VALUE, new org.apache.thrift.meta_data.FieldMetaData("binaryValue", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    tmpMap.put(_Fields.NULL_VALUE, new org.apache.thrift.meta_data.FieldMetaData("nullValue", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.BIG_DECIMAL_VALUE, new org.apache.thrift.meta_data.FieldMetaData("bigDecimalValue", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Literal.class, metaDataMap);
  }

  public Literal() {
    super();
  }

  public Literal(_Fields setField, java.lang.Object value) {
    super(setField, value);
  }

  public Literal(Literal other) {
    super(other);
  }
  public Literal deepCopy() {
    return new Literal(this);
  }

  public static Literal boolValue(boolean value) {
    Literal x = new Literal();
    x.setBoolValue(value);
    return x;
  }

  public static Literal byteValue(byte value) {
    Literal x = new Literal();
    x.setByteValue(value);
    return x;
  }

  public static Literal shortValue(short value) {
    Literal x = new Literal();
    x.setShortValue(value);
    return x;
  }

  public static Literal intValue(int value) {
    Literal x = new Literal();
    x.setIntValue(value);
    return x;
  }

  public static Literal longValue(long value) {
    Literal x = new Literal();
    x.setLongValue(value);
    return x;
  }

  public static Literal doubleValue(double value) {
    Literal x = new Literal();
    x.setDoubleValue(value);
    return x;
  }

  public static Literal stringValue(java.lang.String value) {
    Literal x = new Literal();
    x.setStringValue(value);
    return x;
  }

  public static Literal binaryValue(java.nio.ByteBuffer value) {
    Literal x = new Literal();
    x.setBinaryValue(value);
    return x;
  }

  public static Literal binaryValue(byte[] value) {
    Literal x = new Literal();
    x.setBinaryValue  (java.nio.ByteBuffer.wrap(value.clone()));
    return x;
  }

  public static Literal nullValue(boolean value) {
    Literal x = new Literal();
    x.setNullValue(value);
    return x;
  }

  public static Literal bigDecimalValue(java.nio.ByteBuffer value) {
    Literal x = new Literal();
    x.setBigDecimalValue(value);
    return x;
  }

  public static Literal bigDecimalValue(byte[] value) {
    Literal x = new Literal();
    x.setBigDecimalValue  (java.nio.ByteBuffer.wrap(value.clone()));
    return x;
  }


  @Override
  protected void checkType(_Fields setField, java.lang.Object value) throws java.lang.ClassCastException {
    switch (setField) {
      case BOOL_VALUE:
        if (value instanceof java.lang.Boolean) {
          break;
        }
        throw new java.lang.ClassCastException("Was expecting value of type java.lang.Boolean for field 'boolValue', but got " + value.getClass().getSimpleName());
      case BYTE_VALUE:
        if (value instanceof java.lang.Byte) {
          break;
        }
        throw new java.lang.ClassCastException("Was expecting value of type java.lang.Byte for field 'byteValue', but got " + value.getClass().getSimpleName());
      case SHORT_VALUE:
        if (value instanceof java.lang.Short) {
          break;
        }
        throw new java.lang.ClassCastException("Was expecting value of type java.lang.Short for field 'shortValue', but got " + value.getClass().getSimpleName());
      case INT_VALUE:
        if (value instanceof java.lang.Integer) {
          break;
        }
        throw new java.lang.ClassCastException("Was expecting value of type java.lang.Integer for field 'intValue', but got " + value.getClass().getSimpleName());
      case LONG_VALUE:
        if (value instanceof java.lang.Long) {
          break;
        }
        throw new java.lang.ClassCastException("Was expecting value of type java.lang.Long for field 'longValue', but got " + value.getClass().getSimpleName());
      case DOUBLE_VALUE:
        if (value instanceof java.lang.Double) {
          break;
        }
        throw new java.lang.ClassCastException("Was expecting value of type java.lang.Double for field 'doubleValue', but got " + value.getClass().getSimpleName());
      case STRING_VALUE:
        if (value instanceof java.lang.String) {
          break;
        }
        throw new java.lang.ClassCastException("Was expecting value of type java.lang.String for field 'stringValue', but got " + value.getClass().getSimpleName());
      case BINARY_VALUE:
        if (value instanceof java.nio.ByteBuffer) {
          break;
        }
        throw new java.lang.ClassCastException("Was expecting value of type java.nio.ByteBuffer for field 'binaryValue', but got " + value.getClass().getSimpleName());
      case NULL_VALUE:
        if (value instanceof java.lang.Boolean) {
          break;
        }
        throw new java.lang.ClassCastException("Was expecting value of type java.lang.Boolean for field 'nullValue', but got " + value.getClass().getSimpleName());
      case BIG_DECIMAL_VALUE:
        if (value instanceof java.nio.ByteBuffer) {
          break;
        }
        throw new java.lang.ClassCastException("Was expecting value of type java.nio.ByteBuffer for field 'bigDecimalValue', but got " + value.getClass().getSimpleName());
      default:
        throw new java.lang.IllegalArgumentException("Unknown field id " + setField);
    }
  }

  @Override
  protected java.lang.Object standardSchemeReadValue(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TField field) throws org.apache.thrift.TException {
    _Fields setField = _Fields.findByThriftId(field.id);
    if (setField != null) {
      switch (setField) {
        case BOOL_VALUE:
          if (field.type == BOOL_VALUE_FIELD_DESC.type) {
            java.lang.Boolean boolValue;
            boolValue = iprot.readBool();
            return boolValue;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case BYTE_VALUE:
          if (field.type == BYTE_VALUE_FIELD_DESC.type) {
            java.lang.Byte byteValue;
            byteValue = iprot.readByte();
            return byteValue;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case SHORT_VALUE:
          if (field.type == SHORT_VALUE_FIELD_DESC.type) {
            java.lang.Short shortValue;
            shortValue = iprot.readI16();
            return shortValue;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case INT_VALUE:
          if (field.type == INT_VALUE_FIELD_DESC.type) {
            java.lang.Integer intValue;
            intValue = iprot.readI32();
            return intValue;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case LONG_VALUE:
          if (field.type == LONG_VALUE_FIELD_DESC.type) {
            java.lang.Long longValue;
            longValue = iprot.readI64();
            return longValue;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case DOUBLE_VALUE:
          if (field.type == DOUBLE_VALUE_FIELD_DESC.type) {
            java.lang.Double doubleValue;
            doubleValue = iprot.readDouble();
            return doubleValue;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case STRING_VALUE:
          if (field.type == STRING_VALUE_FIELD_DESC.type) {
            java.lang.String stringValue;
            stringValue = iprot.readString();
            return stringValue;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case BINARY_VALUE:
          if (field.type == BINARY_VALUE_FIELD_DESC.type) {
            java.nio.ByteBuffer binaryValue;
            binaryValue = iprot.readBinary();
            return binaryValue;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case NULL_VALUE:
          if (field.type == NULL_VALUE_FIELD_DESC.type) {
            java.lang.Boolean nullValue;
            nullValue = iprot.readBool();
            return nullValue;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case BIG_DECIMAL_VALUE:
          if (field.type == BIG_DECIMAL_VALUE_FIELD_DESC.type) {
            java.nio.ByteBuffer bigDecimalValue;
            bigDecimalValue = iprot.readBinary();
            return bigDecimalValue;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        default:
          throw new java.lang.IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
      }
    } else {
      org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
      return null;
    }
  }

  @Override
  protected void standardSchemeWriteValue(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    switch (setField_) {
      case BOOL_VALUE:
        java.lang.Boolean boolValue = (java.lang.Boolean)value_;
        oprot.writeBool(boolValue);
        return;
      case BYTE_VALUE:
        java.lang.Byte byteValue = (java.lang.Byte)value_;
        oprot.writeByte(byteValue);
        return;
      case SHORT_VALUE:
        java.lang.Short shortValue = (java.lang.Short)value_;
        oprot.writeI16(shortValue);
        return;
      case INT_VALUE:
        java.lang.Integer intValue = (java.lang.Integer)value_;
        oprot.writeI32(intValue);
        return;
      case LONG_VALUE:
        java.lang.Long longValue = (java.lang.Long)value_;
        oprot.writeI64(longValue);
        return;
      case DOUBLE_VALUE:
        java.lang.Double doubleValue = (java.lang.Double)value_;
        oprot.writeDouble(doubleValue);
        return;
      case STRING_VALUE:
        java.lang.String stringValue = (java.lang.String)value_;
        oprot.writeString(stringValue);
        return;
      case BINARY_VALUE:
        java.nio.ByteBuffer binaryValue = (java.nio.ByteBuffer)value_;
        oprot.writeBinary(binaryValue);
        return;
      case NULL_VALUE:
        java.lang.Boolean nullValue = (java.lang.Boolean)value_;
        oprot.writeBool(nullValue);
        return;
      case BIG_DECIMAL_VALUE:
        java.nio.ByteBuffer bigDecimalValue = (java.nio.ByteBuffer)value_;
        oprot.writeBinary(bigDecimalValue);
        return;
      default:
        throw new java.lang.IllegalStateException("Cannot write union with unknown field " + setField_);
    }
  }

  @Override
  protected java.lang.Object tupleSchemeReadValue(org.apache.thrift.protocol.TProtocol iprot, short fieldID) throws org.apache.thrift.TException {
    _Fields setField = _Fields.findByThriftId(fieldID);
    if (setField != null) {
      switch (setField) {
        case BOOL_VALUE:
          java.lang.Boolean boolValue;
          boolValue = iprot.readBool();
          return boolValue;
        case BYTE_VALUE:
          java.lang.Byte byteValue;
          byteValue = iprot.readByte();
          return byteValue;
        case SHORT_VALUE:
          java.lang.Short shortValue;
          shortValue = iprot.readI16();
          return shortValue;
        case INT_VALUE:
          java.lang.Integer intValue;
          intValue = iprot.readI32();
          return intValue;
        case LONG_VALUE:
          java.lang.Long longValue;
          longValue = iprot.readI64();
          return longValue;
        case DOUBLE_VALUE:
          java.lang.Double doubleValue;
          doubleValue = iprot.readDouble();
          return doubleValue;
        case STRING_VALUE:
          java.lang.String stringValue;
          stringValue = iprot.readString();
          return stringValue;
        case BINARY_VALUE:
          java.nio.ByteBuffer binaryValue;
          binaryValue = iprot.readBinary();
          return binaryValue;
        case NULL_VALUE:
          java.lang.Boolean nullValue;
          nullValue = iprot.readBool();
          return nullValue;
        case BIG_DECIMAL_VALUE:
          java.nio.ByteBuffer bigDecimalValue;
          bigDecimalValue = iprot.readBinary();
          return bigDecimalValue;
        default:
          throw new java.lang.IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
      }
    } else {
      throw new org.apache.thrift.protocol.TProtocolException("Couldn't find a field with field id " + fieldID);
    }
  }

  @Override
  protected void tupleSchemeWriteValue(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    switch (setField_) {
      case BOOL_VALUE:
        java.lang.Boolean boolValue = (java.lang.Boolean)value_;
        oprot.writeBool(boolValue);
        return;
      case BYTE_VALUE:
        java.lang.Byte byteValue = (java.lang.Byte)value_;
        oprot.writeByte(byteValue);
        return;
      case SHORT_VALUE:
        java.lang.Short shortValue = (java.lang.Short)value_;
        oprot.writeI16(shortValue);
        return;
      case INT_VALUE:
        java.lang.Integer intValue = (java.lang.Integer)value_;
        oprot.writeI32(intValue);
        return;
      case LONG_VALUE:
        java.lang.Long longValue = (java.lang.Long)value_;
        oprot.writeI64(longValue);
        return;
      case DOUBLE_VALUE:
        java.lang.Double doubleValue = (java.lang.Double)value_;
        oprot.writeDouble(doubleValue);
        return;
      case STRING_VALUE:
        java.lang.String stringValue = (java.lang.String)value_;
        oprot.writeString(stringValue);
        return;
      case BINARY_VALUE:
        java.nio.ByteBuffer binaryValue = (java.nio.ByteBuffer)value_;
        oprot.writeBinary(binaryValue);
        return;
      case NULL_VALUE:
        java.lang.Boolean nullValue = (java.lang.Boolean)value_;
        oprot.writeBool(nullValue);
        return;
      case BIG_DECIMAL_VALUE:
        java.nio.ByteBuffer bigDecimalValue = (java.nio.ByteBuffer)value_;
        oprot.writeBinary(bigDecimalValue);
        return;
      default:
        throw new java.lang.IllegalStateException("Cannot write union with unknown field " + setField_);
    }
  }

  @Override
  protected org.apache.thrift.protocol.TField getFieldDesc(_Fields setField) {
    switch (setField) {
      case BOOL_VALUE:
        return BOOL_VALUE_FIELD_DESC;
      case BYTE_VALUE:
        return BYTE_VALUE_FIELD_DESC;
      case SHORT_VALUE:
        return SHORT_VALUE_FIELD_DESC;
      case INT_VALUE:
        return INT_VALUE_FIELD_DESC;
      case LONG_VALUE:
        return LONG_VALUE_FIELD_DESC;
      case DOUBLE_VALUE:
        return DOUBLE_VALUE_FIELD_DESC;
      case STRING_VALUE:
        return STRING_VALUE_FIELD_DESC;
      case BINARY_VALUE:
        return BINARY_VALUE_FIELD_DESC;
      case NULL_VALUE:
        return NULL_VALUE_FIELD_DESC;
      case BIG_DECIMAL_VALUE:
        return BIG_DECIMAL_VALUE_FIELD_DESC;
      default:
        throw new java.lang.IllegalArgumentException("Unknown field id " + setField);
    }
  }

  @Override
  protected org.apache.thrift.protocol.TStruct getStructDesc() {
    return STRUCT_DESC;
  }

  @Override
  protected _Fields enumForId(short id) {
    return _Fields.findByThriftIdOrThrow(id);
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }


  public boolean getBoolValue() {
    if (getSetField() == _Fields.BOOL_VALUE) {
      return (java.lang.Boolean)getFieldValue();
    } else {
      throw new java.lang.RuntimeException("Cannot get field 'boolValue' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setBoolValue(boolean value) {
    setField_ = _Fields.BOOL_VALUE;
    value_ = value;
  }

  public byte getByteValue() {
    if (getSetField() == _Fields.BYTE_VALUE) {
      return (java.lang.Byte)getFieldValue();
    } else {
      throw new java.lang.RuntimeException("Cannot get field 'byteValue' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setByteValue(byte value) {
    setField_ = _Fields.BYTE_VALUE;
    value_ = value;
  }

  public short getShortValue() {
    if (getSetField() == _Fields.SHORT_VALUE) {
      return (java.lang.Short)getFieldValue();
    } else {
      throw new java.lang.RuntimeException("Cannot get field 'shortValue' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setShortValue(short value) {
    setField_ = _Fields.SHORT_VALUE;
    value_ = value;
  }

  public int getIntValue() {
    if (getSetField() == _Fields.INT_VALUE) {
      return (java.lang.Integer)getFieldValue();
    } else {
      throw new java.lang.RuntimeException("Cannot get field 'intValue' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setIntValue(int value) {
    setField_ = _Fields.INT_VALUE;
    value_ = value;
  }

  public long getLongValue() {
    if (getSetField() == _Fields.LONG_VALUE) {
      return (java.lang.Long)getFieldValue();
    } else {
      throw new java.lang.RuntimeException("Cannot get field 'longValue' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setLongValue(long value) {
    setField_ = _Fields.LONG_VALUE;
    value_ = value;
  }

  public double getDoubleValue() {
    if (getSetField() == _Fields.DOUBLE_VALUE) {
      return (java.lang.Double)getFieldValue();
    } else {
      throw new java.lang.RuntimeException("Cannot get field 'doubleValue' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setDoubleValue(double value) {
    setField_ = _Fields.DOUBLE_VALUE;
    value_ = value;
  }

  public java.lang.String getStringValue() {
    if (getSetField() == _Fields.STRING_VALUE) {
      return (java.lang.String)getFieldValue();
    } else {
      throw new java.lang.RuntimeException("Cannot get field 'stringValue' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setStringValue(java.lang.String value) {
    setField_ = _Fields.STRING_VALUE;
    value_ = java.util.Objects.requireNonNull(value,"_Fields.STRING_VALUE");
  }

  public byte[] getBinaryValue() {
    setBinaryValue(org.apache.thrift.TBaseHelper.rightSize(bufferForBinaryValue()));
    java.nio.ByteBuffer b = bufferForBinaryValue();
    return b == null ? null : b.array();
  }

  public java.nio.ByteBuffer bufferForBinaryValue() {
    if (getSetField() == _Fields.BINARY_VALUE) {
      return org.apache.thrift.TBaseHelper.copyBinary((java.nio.ByteBuffer)getFieldValue());
    } else {
      throw new java.lang.RuntimeException("Cannot get field 'binaryValue' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setBinaryValue(byte[] value) {
    setBinaryValue  (java.nio.ByteBuffer.wrap(value.clone()));
  }

  public void setBinaryValue(java.nio.ByteBuffer value) {
    setField_ = _Fields.BINARY_VALUE;
    value_ = java.util.Objects.requireNonNull(value,"_Fields.BINARY_VALUE");
  }

  public boolean getNullValue() {
    if (getSetField() == _Fields.NULL_VALUE) {
      return (java.lang.Boolean)getFieldValue();
    } else {
      throw new java.lang.RuntimeException("Cannot get field 'nullValue' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setNullValue(boolean value) {
    setField_ = _Fields.NULL_VALUE;
    value_ = value;
  }

  public byte[] getBigDecimalValue() {
    setBigDecimalValue(org.apache.thrift.TBaseHelper.rightSize(bufferForBigDecimalValue()));
    java.nio.ByteBuffer b = bufferForBigDecimalValue();
    return b == null ? null : b.array();
  }

  public java.nio.ByteBuffer bufferForBigDecimalValue() {
    if (getSetField() == _Fields.BIG_DECIMAL_VALUE) {
      return org.apache.thrift.TBaseHelper.copyBinary((java.nio.ByteBuffer)getFieldValue());
    } else {
      throw new java.lang.RuntimeException("Cannot get field 'bigDecimalValue' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setBigDecimalValue(byte[] value) {
    setBigDecimalValue  (java.nio.ByteBuffer.wrap(value.clone()));
  }

  public void setBigDecimalValue(java.nio.ByteBuffer value) {
    setField_ = _Fields.BIG_DECIMAL_VALUE;
    value_ = java.util.Objects.requireNonNull(value,"_Fields.BIG_DECIMAL_VALUE");
  }

  public boolean isSetBoolValue() {
    return setField_ == _Fields.BOOL_VALUE;
  }


  public boolean isSetByteValue() {
    return setField_ == _Fields.BYTE_VALUE;
  }


  public boolean isSetShortValue() {
    return setField_ == _Fields.SHORT_VALUE;
  }


  public boolean isSetIntValue() {
    return setField_ == _Fields.INT_VALUE;
  }


  public boolean isSetLongValue() {
    return setField_ == _Fields.LONG_VALUE;
  }


  public boolean isSetDoubleValue() {
    return setField_ == _Fields.DOUBLE_VALUE;
  }


  public boolean isSetStringValue() {
    return setField_ == _Fields.STRING_VALUE;
  }


  public boolean isSetBinaryValue() {
    return setField_ == _Fields.BINARY_VALUE;
  }


  public boolean isSetNullValue() {
    return setField_ == _Fields.NULL_VALUE;
  }


  public boolean isSetBigDecimalValue() {
    return setField_ == _Fields.BIG_DECIMAL_VALUE;
  }


  public boolean equals(java.lang.Object other) {
    if (other instanceof Literal) {
      return equals((Literal)other);
    } else {
      return false;
    }
  }

  public boolean equals(Literal other) {
    return other != null && getSetField() == other.getSetField() && getFieldValue().equals(other.getFieldValue());
  }

  @Override
  public int compareTo(Literal other) {
    int lastComparison = org.apache.thrift.TBaseHelper.compareTo(getSetField(), other.getSetField());
    if (lastComparison == 0) {
      return org.apache.thrift.TBaseHelper.compareTo(getFieldValue(), other.getFieldValue());
    }
    return lastComparison;
  }


  @Override
  public int hashCode() {
    java.util.List<java.lang.Object> list = new java.util.ArrayList<java.lang.Object>();
    list.add(this.getClass().getName());
    org.apache.thrift.TFieldIdEnum setField = getSetField();
    if (setField != null) {
      list.add(setField.getThriftFieldId());
      java.lang.Object value = getFieldValue();
      if (value instanceof org.apache.thrift.TEnum) {
        list.add(((org.apache.thrift.TEnum)getFieldValue()).getValue());
      } else {
        list.add(value);
      }
    }
    return list.hashCode();
  }
  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }


  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }


}
