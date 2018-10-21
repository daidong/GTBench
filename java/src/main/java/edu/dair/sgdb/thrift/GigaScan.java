/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package edu.dair.sgdb.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2018-10-20")
public class GigaScan implements org.apache.thrift.TBase<GigaScan, GigaScan._Fields>, java.io.Serializable, Cloneable, Comparable<GigaScan> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("GigaScan");

  private static final org.apache.thrift.protocol.TField KVS_FIELD_DESC = new org.apache.thrift.protocol.TField("kvs", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField BITMAP_FIELD_DESC = new org.apache.thrift.protocol.TField("bitmap", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new GigaScanStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new GigaScanTupleSchemeFactory();

  public java.util.List<KeyValue> kvs; // required
  public java.nio.ByteBuffer bitmap; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    KVS((short)1, "kvs"),
    BITMAP((short)2, "bitmap");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // KVS
          return KVS;
        case 2: // BITMAP
          return BITMAP;
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

  // isset id assignments
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.KVS, new org.apache.thrift.meta_data.FieldMetaData("kvs", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, KeyValue.class))));
    tmpMap.put(_Fields.BITMAP, new org.apache.thrift.meta_data.FieldMetaData("bitmap", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(GigaScan.class, metaDataMap);
  }

  public GigaScan() {
  }

  public GigaScan(
    java.util.List<KeyValue> kvs,
    java.nio.ByteBuffer bitmap)
  {
    this();
    this.kvs = kvs;
    this.bitmap = org.apache.thrift.TBaseHelper.copyBinary(bitmap);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public GigaScan(GigaScan other) {
    if (other.isSetKvs()) {
      java.util.List<KeyValue> __this__kvs = new java.util.ArrayList<KeyValue>(other.kvs.size());
      for (KeyValue other_element : other.kvs) {
        __this__kvs.add(new KeyValue(other_element));
      }
      this.kvs = __this__kvs;
    }
    if (other.isSetBitmap()) {
      this.bitmap = org.apache.thrift.TBaseHelper.copyBinary(other.bitmap);
    }
  }

  public GigaScan deepCopy() {
    return new GigaScan(this);
  }

  @Override
  public void clear() {
    this.kvs = null;
    this.bitmap = null;
  }

  public int getKvsSize() {
    return (this.kvs == null) ? 0 : this.kvs.size();
  }

  public java.util.Iterator<KeyValue> getKvsIterator() {
    return (this.kvs == null) ? null : this.kvs.iterator();
  }

  public void addToKvs(KeyValue elem) {
    if (this.kvs == null) {
      this.kvs = new java.util.ArrayList<KeyValue>();
    }
    this.kvs.add(elem);
  }

  public java.util.List<KeyValue> getKvs() {
    return this.kvs;
  }

  public GigaScan setKvs(java.util.List<KeyValue> kvs) {
    this.kvs = kvs;
    return this;
  }

  public void unsetKvs() {
    this.kvs = null;
  }

  /** Returns true if field kvs is set (has been assigned a value) and false otherwise */
  public boolean isSetKvs() {
    return this.kvs != null;
  }

  public void setKvsIsSet(boolean value) {
    if (!value) {
      this.kvs = null;
    }
  }

  public byte[] getBitmap() {
    setBitmap(org.apache.thrift.TBaseHelper.rightSize(bitmap));
    return bitmap == null ? null : bitmap.array();
  }

  public java.nio.ByteBuffer bufferForBitmap() {
    return org.apache.thrift.TBaseHelper.copyBinary(bitmap);
  }

  public GigaScan setBitmap(byte[] bitmap) {
    this.bitmap = bitmap == null ? (java.nio.ByteBuffer)null : java.nio.ByteBuffer.wrap(bitmap.clone());
    return this;
  }

  public GigaScan setBitmap(java.nio.ByteBuffer bitmap) {
    this.bitmap = org.apache.thrift.TBaseHelper.copyBinary(bitmap);
    return this;
  }

  public void unsetBitmap() {
    this.bitmap = null;
  }

  /** Returns true if field bitmap is set (has been assigned a value) and false otherwise */
  public boolean isSetBitmap() {
    return this.bitmap != null;
  }

  public void setBitmapIsSet(boolean value) {
    if (!value) {
      this.bitmap = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case KVS:
      if (value == null) {
        unsetKvs();
      } else {
        setKvs((java.util.List<KeyValue>)value);
      }
      break;

    case BITMAP:
      if (value == null) {
        unsetBitmap();
      } else {
        if (value instanceof byte[]) {
          setBitmap((byte[])value);
        } else {
          setBitmap((java.nio.ByteBuffer)value);
        }
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case KVS:
      return getKvs();

    case BITMAP:
      return getBitmap();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case KVS:
      return isSetKvs();
    case BITMAP:
      return isSetBitmap();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof GigaScan)
      return this.equals((GigaScan)that);
    return false;
  }

  public boolean equals(GigaScan that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_kvs = true && this.isSetKvs();
    boolean that_present_kvs = true && that.isSetKvs();
    if (this_present_kvs || that_present_kvs) {
      if (!(this_present_kvs && that_present_kvs))
        return false;
      if (!this.kvs.equals(that.kvs))
        return false;
    }

    boolean this_present_bitmap = true && this.isSetBitmap();
    boolean that_present_bitmap = true && that.isSetBitmap();
    if (this_present_bitmap || that_present_bitmap) {
      if (!(this_present_bitmap && that_present_bitmap))
        return false;
      if (!this.bitmap.equals(that.bitmap))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetKvs()) ? 131071 : 524287);
    if (isSetKvs())
      hashCode = hashCode * 8191 + kvs.hashCode();

    hashCode = hashCode * 8191 + ((isSetBitmap()) ? 131071 : 524287);
    if (isSetBitmap())
      hashCode = hashCode * 8191 + bitmap.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(GigaScan other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetKvs()).compareTo(other.isSetKvs());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetKvs()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.kvs, other.kvs);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetBitmap()).compareTo(other.isSetBitmap());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBitmap()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.bitmap, other.bitmap);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("GigaScan(");
    boolean first = true;

    sb.append("kvs:");
    if (this.kvs == null) {
      sb.append("null");
    } else {
      sb.append(this.kvs);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("bitmap:");
    if (this.bitmap == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.bitmap, sb);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (kvs == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'kvs' was not present! Struct: " + toString());
    }
    if (bitmap == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'bitmap' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
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

  private static class GigaScanStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public GigaScanStandardScheme getScheme() {
      return new GigaScanStandardScheme();
    }
  }

  private static class GigaScanStandardScheme extends org.apache.thrift.scheme.StandardScheme<GigaScan> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, GigaScan struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // KVS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.kvs = new java.util.ArrayList<KeyValue>(_list0.size);
                KeyValue _elem1;
                for (int _i2 = 0; _i2 < _list0.size; ++_i2)
                {
                  _elem1 = new KeyValue();
                  _elem1.read(iprot);
                  struct.kvs.add(_elem1);
                }
                iprot.readListEnd();
              }
              struct.setKvsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // BITMAP
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.bitmap = iprot.readBinary();
              struct.setBitmapIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, GigaScan struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.kvs != null) {
        oprot.writeFieldBegin(KVS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.kvs.size()));
          for (KeyValue _iter3 : struct.kvs)
          {
            _iter3.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.bitmap != null) {
        oprot.writeFieldBegin(BITMAP_FIELD_DESC);
        oprot.writeBinary(struct.bitmap);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class GigaScanTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public GigaScanTupleScheme getScheme() {
      return new GigaScanTupleScheme();
    }
  }

  private static class GigaScanTupleScheme extends org.apache.thrift.scheme.TupleScheme<GigaScan> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, GigaScan struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      {
        oprot.writeI32(struct.kvs.size());
        for (KeyValue _iter4 : struct.kvs)
        {
          _iter4.write(oprot);
        }
      }
      oprot.writeBinary(struct.bitmap);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, GigaScan struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      {
        org.apache.thrift.protocol.TList _list5 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
        struct.kvs = new java.util.ArrayList<KeyValue>(_list5.size);
        KeyValue _elem6;
        for (int _i7 = 0; _i7 < _list5.size; ++_i7)
        {
          _elem6 = new KeyValue();
          _elem6.read(iprot);
          struct.kvs.add(_elem6);
        }
      }
      struct.setKvsIsSet(true);
      struct.bitmap = iprot.readBinary();
      struct.setBitmapIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

