/**
 * Autogenerated by Thrift Compiler (0.8.0-dev)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.rapleaf.hank.generated;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HankResponse extends org.apache.thrift.TUnion<HankResponse, HankResponse._Fields> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("HankResponse");
  private static final org.apache.thrift.protocol.TField NOT_FOUND_FIELD_DESC = new org.apache.thrift.protocol.TField("not_found", org.apache.thrift.protocol.TType.BOOL, (short)1);
  private static final org.apache.thrift.protocol.TField VALUE_FIELD_DESC = new org.apache.thrift.protocol.TField("value", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField XCEPTION_FIELD_DESC = new org.apache.thrift.protocol.TField("xception", org.apache.thrift.protocol.TType.STRUCT, (short)3);

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    NOT_FOUND((short)1, "not_found"),
    VALUE((short)2, "value"),
    XCEPTION((short)3, "xception");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // NOT_FOUND
          return NOT_FOUND;
        case 2: // VALUE
          return VALUE;
        case 3: // XCEPTION
          return XCEPTION;
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
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.NOT_FOUND, new org.apache.thrift.meta_data.FieldMetaData("not_found", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.VALUE, new org.apache.thrift.meta_data.FieldMetaData("value", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    tmpMap.put(_Fields.XCEPTION, new org.apache.thrift.meta_data.FieldMetaData("xception", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, HankException.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(HankResponse.class, metaDataMap);
  }

  public HankResponse() {
    super();
  }

  public HankResponse(_Fields setField, Object value) {
    super(setField, value);
  }

  public HankResponse(HankResponse other) {
    super(other);
  }
  public HankResponse deepCopy() {
    return new HankResponse(this);
  }

  public static HankResponse not_found(boolean value) {
    HankResponse x = new HankResponse();
    x.set_not_found(value);
    return x;
  }

  public static HankResponse value(ByteBuffer value) {
    HankResponse x = new HankResponse();
    x.set_value(value);
    return x;
  }

  public static HankResponse value(byte[] value) {
    HankResponse x = new HankResponse();
    x.set_value(ByteBuffer.wrap(value));
    return x;
  }

  public static HankResponse xception(HankException value) {
    HankResponse x = new HankResponse();
    x.set_xception(value);
    return x;
  }


  @Override
  protected void checkType(_Fields setField, Object value) throws ClassCastException {
    switch (setField) {
      case NOT_FOUND:
        if (value instanceof Boolean) {
          break;
        }
        throw new ClassCastException("Was expecting value of type Boolean for field 'not_found', but got " + value.getClass().getSimpleName());
      case VALUE:
        if (value instanceof ByteBuffer) {
          break;
        }
        throw new ClassCastException("Was expecting value of type ByteBuffer for field 'value', but got " + value.getClass().getSimpleName());
      case XCEPTION:
        if (value instanceof HankException) {
          break;
        }
        throw new ClassCastException("Was expecting value of type HankException for field 'xception', but got " + value.getClass().getSimpleName());
      default:
        throw new IllegalArgumentException("Unknown field id " + setField);
    }
  }

  @Override
  protected Object standardSchemeReadValue(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TField field) throws org.apache.thrift.TException {
    _Fields setField = _Fields.findByThriftId(field.id);
    if (setField != null) {
      switch (setField) {
        case NOT_FOUND:
          if (field.type == NOT_FOUND_FIELD_DESC.type) {
            Boolean not_found;
            not_found = iprot.readBool();
            return not_found;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case VALUE:
          if (field.type == VALUE_FIELD_DESC.type) {
            ByteBuffer value;
            value = iprot.readBinary();
            return value;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case XCEPTION:
          if (field.type == XCEPTION_FIELD_DESC.type) {
            HankException xception;
            xception = new HankException();
            xception.read(iprot);
            return xception;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        default:
          throw new IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
      }
    } else {
      return null;
    }
  }

  @Override
  protected void standardSchemeWriteValue(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    switch (setField_) {
      case NOT_FOUND:
        Boolean not_found = (Boolean)value_;
        oprot.writeBool(not_found);
        return;
      case VALUE:
        ByteBuffer value = (ByteBuffer)value_;
        oprot.writeBinary(value);
        return;
      case XCEPTION:
        HankException xception = (HankException)value_;
        xception.write(oprot);
        return;
      default:
        throw new IllegalStateException("Cannot write union with unknown field " + setField_);
    }
  }

  @Override
  protected Object tupleSchemeReadValue(org.apache.thrift.protocol.TProtocol iprot, short fieldID) throws org.apache.thrift.TException {
    _Fields setField = _Fields.findByThriftId(fieldID);
    if (setField != null) {
      switch (setField) {
        case NOT_FOUND:
          Boolean not_found;
          not_found = iprot.readBool();
          return not_found;
        case VALUE:
          ByteBuffer value;
          value = iprot.readBinary();
          return value;
        case XCEPTION:
          HankException xception;
          xception = new HankException();
          xception.read(iprot);
          return xception;
        default:
          throw new IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
      }
    } else {
      return null;
    }
  }

  @Override
  protected void tupleSchemeWriteValue(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    switch (setField_) {
      case NOT_FOUND:
        Boolean not_found = (Boolean)value_;
        oprot.writeBool(not_found);
        return;
      case VALUE:
        ByteBuffer value = (ByteBuffer)value_;
        oprot.writeBinary(value);
        return;
      case XCEPTION:
        HankException xception = (HankException)value_;
        xception.write(oprot);
        return;
      default:
        throw new IllegalStateException("Cannot write union with unknown field " + setField_);
    }
  }

  @Override
  protected org.apache.thrift.protocol.TField getFieldDesc(_Fields setField) {
    switch (setField) {
      case NOT_FOUND:
        return NOT_FOUND_FIELD_DESC;
      case VALUE:
        return VALUE_FIELD_DESC;
      case XCEPTION:
        return XCEPTION_FIELD_DESC;
      default:
        throw new IllegalArgumentException("Unknown field id " + setField);
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

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }


  public boolean get_not_found() {
    if (getSetField() == _Fields.NOT_FOUND) {
      return (Boolean)getFieldValue();
    } else {
      throw new RuntimeException("Cannot get field 'not_found' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void set_not_found(boolean value) {
    setField_ = _Fields.NOT_FOUND;
    value_ = value;
  }

  public byte[] get_value() {
    set_value(org.apache.thrift.TBaseHelper.rightSize(buffer_for_value()));
    ByteBuffer b = buffer_for_value();
    return b == null ? null : b.array();
  }

  public ByteBuffer buffer_for_value() {
    if (getSetField() == _Fields.VALUE) {
      return (ByteBuffer)getFieldValue();
    } else {
      throw new RuntimeException("Cannot get field 'value' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void set_value(byte[] value) {
    set_value(ByteBuffer.wrap(value));
  }

  public void set_value(ByteBuffer value) {
    if (value == null) throw new NullPointerException();
    setField_ = _Fields.VALUE;
    value_ = value;
  }

  public HankException get_xception() {
    if (getSetField() == _Fields.XCEPTION) {
      return (HankException)getFieldValue();
    } else {
      throw new RuntimeException("Cannot get field 'xception' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void set_xception(HankException value) {
    if (value == null) throw new NullPointerException();
    setField_ = _Fields.XCEPTION;
    value_ = value;
  }

  public boolean is_set_not_found() {
    return setField_ == _Fields.NOT_FOUND;
  }


  public boolean is_set_value() {
    return setField_ == _Fields.VALUE;
  }


  public boolean is_set_xception() {
    return setField_ == _Fields.XCEPTION;
  }


  public boolean equals(Object other) {
    if (other instanceof HankResponse) {
      return equals((HankResponse)other);
    } else {
      return false;
    }
  }

  public boolean equals(HankResponse other) {
    return other != null && getSetField() == other.getSetField() && getFieldValue().equals(other.getFieldValue());
  }

  @Override
  public int compareTo(HankResponse other) {
    int lastComparison = org.apache.thrift.TBaseHelper.compareTo(getSetField(), other.getSetField());
    if (lastComparison == 0) {
      return org.apache.thrift.TBaseHelper.compareTo(getFieldValue(), other.getFieldValue());
    }
    return lastComparison;
  }


  @Override
  public int hashCode() {
    HashCodeBuilder hcb = new HashCodeBuilder();
    hcb.append(this.getClass().getName());
    org.apache.thrift.TFieldIdEnum setField = getSetField();
    if (setField != null) {
      hcb.append(setField.getThriftFieldId());
      Object value = getFieldValue();
      if (value instanceof org.apache.thrift.TEnum) {
        hcb.append(((org.apache.thrift.TEnum)getFieldValue()).getValue());
      } else {
        hcb.append(value);
      }
    }
    return hcb.toHashCode();
  }
  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }


  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }


}
