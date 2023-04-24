/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package magicalpipelines.model;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class EntityGaze extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -4600662409374154843L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"EntityGaze\",\"namespace\":\"magicalpipelines.model\",\"fields\":[{\"name\":\"Timestamp\",\"type\":\"long\"},{\"name\":\"Xpos\",\"type\":\"double\"},{\"name\":\"Ypos\",\"type\":\"double\"},{\"name\":\"PupilSize\",\"type\":\"double\"},{\"name\":\"AOI\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<EntityGaze> ENCODER =
      new BinaryMessageEncoder<EntityGaze>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<EntityGaze> DECODER =
      new BinaryMessageDecoder<EntityGaze>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<EntityGaze> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<EntityGaze> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<EntityGaze>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this EntityGaze to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a EntityGaze from a ByteBuffer. */
  public static EntityGaze fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public long Timestamp;
  @Deprecated public double Xpos;
  @Deprecated public double Ypos;
  @Deprecated public double PupilSize;
  @Deprecated public java.lang.CharSequence AOI;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public EntityGaze() {}

  /**
   * All-args constructor.
   * @param Timestamp The new value for Timestamp
   * @param Xpos The new value for Xpos
   * @param Ypos The new value for Ypos
   * @param PupilSize The new value for PupilSize
   * @param AOI The new value for AOI
   */
  public EntityGaze(java.lang.Long Timestamp, java.lang.Double Xpos, java.lang.Double Ypos, java.lang.Double PupilSize, java.lang.CharSequence AOI) {
    this.Timestamp = Timestamp;
    this.Xpos = Xpos;
    this.Ypos = Ypos;
    this.PupilSize = PupilSize;
    this.AOI = AOI;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return Timestamp;
    case 1: return Xpos;
    case 2: return Ypos;
    case 3: return PupilSize;
    case 4: return AOI;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: Timestamp = (java.lang.Long)value$; break;
    case 1: Xpos = (java.lang.Double)value$; break;
    case 2: Ypos = (java.lang.Double)value$; break;
    case 3: PupilSize = (java.lang.Double)value$; break;
    case 4: AOI = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'Timestamp' field.
   * @return The value of the 'Timestamp' field.
   */
  public java.lang.Long getTimestamp() {
    return Timestamp;
  }

  /**
   * Sets the value of the 'Timestamp' field.
   * @param value the value to set.
   */
  public void setTimestamp(java.lang.Long value) {
    this.Timestamp = value;
  }

  /**
   * Gets the value of the 'Xpos' field.
   * @return The value of the 'Xpos' field.
   */
  public java.lang.Double getXpos() {
    return Xpos;
  }

  /**
   * Sets the value of the 'Xpos' field.
   * @param value the value to set.
   */
  public void setXpos(java.lang.Double value) {
    this.Xpos = value;
  }

  /**
   * Gets the value of the 'Ypos' field.
   * @return The value of the 'Ypos' field.
   */
  public java.lang.Double getYpos() {
    return Ypos;
  }

  /**
   * Sets the value of the 'Ypos' field.
   * @param value the value to set.
   */
  public void setYpos(java.lang.Double value) {
    this.Ypos = value;
  }

  /**
   * Gets the value of the 'PupilSize' field.
   * @return The value of the 'PupilSize' field.
   */
  public java.lang.Double getPupilSize() {
    return PupilSize;
  }

  /**
   * Sets the value of the 'PupilSize' field.
   * @param value the value to set.
   */
  public void setPupilSize(java.lang.Double value) {
    this.PupilSize = value;
  }

  /**
   * Gets the value of the 'AOI' field.
   * @return The value of the 'AOI' field.
   */
  public java.lang.CharSequence getAOI() {
    return AOI;
  }

  /**
   * Sets the value of the 'AOI' field.
   * @param value the value to set.
   */
  public void setAOI(java.lang.CharSequence value) {
    this.AOI = value;
  }

  /**
   * Creates a new EntityGaze RecordBuilder.
   * @return A new EntityGaze RecordBuilder
   */
  public static magicalpipelines.model.EntityGaze.Builder newBuilder() {
    return new magicalpipelines.model.EntityGaze.Builder();
  }

  /**
   * Creates a new EntityGaze RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new EntityGaze RecordBuilder
   */
  public static magicalpipelines.model.EntityGaze.Builder newBuilder(magicalpipelines.model.EntityGaze.Builder other) {
    return new magicalpipelines.model.EntityGaze.Builder(other);
  }

  /**
   * Creates a new EntityGaze RecordBuilder by copying an existing EntityGaze instance.
   * @param other The existing instance to copy.
   * @return A new EntityGaze RecordBuilder
   */
  public static magicalpipelines.model.EntityGaze.Builder newBuilder(magicalpipelines.model.EntityGaze other) {
    return new magicalpipelines.model.EntityGaze.Builder(other);
  }

  /**
   * RecordBuilder for EntityGaze instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<EntityGaze>
    implements org.apache.avro.data.RecordBuilder<EntityGaze> {

    private long Timestamp;
    private double Xpos;
    private double Ypos;
    private double PupilSize;
    private java.lang.CharSequence AOI;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(magicalpipelines.model.EntityGaze.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.Timestamp)) {
        this.Timestamp = data().deepCopy(fields()[0].schema(), other.Timestamp);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.Xpos)) {
        this.Xpos = data().deepCopy(fields()[1].schema(), other.Xpos);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.Ypos)) {
        this.Ypos = data().deepCopy(fields()[2].schema(), other.Ypos);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.PupilSize)) {
        this.PupilSize = data().deepCopy(fields()[3].schema(), other.PupilSize);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.AOI)) {
        this.AOI = data().deepCopy(fields()[4].schema(), other.AOI);
        fieldSetFlags()[4] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing EntityGaze instance
     * @param other The existing instance to copy.
     */
    private Builder(magicalpipelines.model.EntityGaze other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.Timestamp)) {
        this.Timestamp = data().deepCopy(fields()[0].schema(), other.Timestamp);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.Xpos)) {
        this.Xpos = data().deepCopy(fields()[1].schema(), other.Xpos);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.Ypos)) {
        this.Ypos = data().deepCopy(fields()[2].schema(), other.Ypos);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.PupilSize)) {
        this.PupilSize = data().deepCopy(fields()[3].schema(), other.PupilSize);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.AOI)) {
        this.AOI = data().deepCopy(fields()[4].schema(), other.AOI);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'Timestamp' field.
      * @return The value.
      */
    public java.lang.Long getTimestamp() {
      return Timestamp;
    }

    /**
      * Sets the value of the 'Timestamp' field.
      * @param value The value of 'Timestamp'.
      * @return This builder.
      */
    public magicalpipelines.model.EntityGaze.Builder setTimestamp(long value) {
      validate(fields()[0], value);
      this.Timestamp = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'Timestamp' field has been set.
      * @return True if the 'Timestamp' field has been set, false otherwise.
      */
    public boolean hasTimestamp() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'Timestamp' field.
      * @return This builder.
      */
    public magicalpipelines.model.EntityGaze.Builder clearTimestamp() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'Xpos' field.
      * @return The value.
      */
    public java.lang.Double getXpos() {
      return Xpos;
    }

    /**
      * Sets the value of the 'Xpos' field.
      * @param value The value of 'Xpos'.
      * @return This builder.
      */
    public magicalpipelines.model.EntityGaze.Builder setXpos(double value) {
      validate(fields()[1], value);
      this.Xpos = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'Xpos' field has been set.
      * @return True if the 'Xpos' field has been set, false otherwise.
      */
    public boolean hasXpos() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'Xpos' field.
      * @return This builder.
      */
    public magicalpipelines.model.EntityGaze.Builder clearXpos() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'Ypos' field.
      * @return The value.
      */
    public java.lang.Double getYpos() {
      return Ypos;
    }

    /**
      * Sets the value of the 'Ypos' field.
      * @param value The value of 'Ypos'.
      * @return This builder.
      */
    public magicalpipelines.model.EntityGaze.Builder setYpos(double value) {
      validate(fields()[2], value);
      this.Ypos = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'Ypos' field has been set.
      * @return True if the 'Ypos' field has been set, false otherwise.
      */
    public boolean hasYpos() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'Ypos' field.
      * @return This builder.
      */
    public magicalpipelines.model.EntityGaze.Builder clearYpos() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'PupilSize' field.
      * @return The value.
      */
    public java.lang.Double getPupilSize() {
      return PupilSize;
    }

    /**
      * Sets the value of the 'PupilSize' field.
      * @param value The value of 'PupilSize'.
      * @return This builder.
      */
    public magicalpipelines.model.EntityGaze.Builder setPupilSize(double value) {
      validate(fields()[3], value);
      this.PupilSize = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'PupilSize' field has been set.
      * @return True if the 'PupilSize' field has been set, false otherwise.
      */
    public boolean hasPupilSize() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'PupilSize' field.
      * @return This builder.
      */
    public magicalpipelines.model.EntityGaze.Builder clearPupilSize() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'AOI' field.
      * @return The value.
      */
    public java.lang.CharSequence getAOI() {
      return AOI;
    }

    /**
      * Sets the value of the 'AOI' field.
      * @param value The value of 'AOI'.
      * @return This builder.
      */
    public magicalpipelines.model.EntityGaze.Builder setAOI(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.AOI = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'AOI' field has been set.
      * @return True if the 'AOI' field has been set, false otherwise.
      */
    public boolean hasAOI() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'AOI' field.
      * @return This builder.
      */
    public magicalpipelines.model.EntityGaze.Builder clearAOI() {
      AOI = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public EntityGaze build() {
      try {
        EntityGaze record = new EntityGaze();
        record.Timestamp = fieldSetFlags()[0] ? this.Timestamp : (java.lang.Long) defaultValue(fields()[0]);
        record.Xpos = fieldSetFlags()[1] ? this.Xpos : (java.lang.Double) defaultValue(fields()[1]);
        record.Ypos = fieldSetFlags()[2] ? this.Ypos : (java.lang.Double) defaultValue(fields()[2]);
        record.PupilSize = fieldSetFlags()[3] ? this.PupilSize : (java.lang.Double) defaultValue(fields()[3]);
        record.AOI = fieldSetFlags()[4] ? this.AOI : (java.lang.CharSequence) defaultValue(fields()[4]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<EntityGaze>
    WRITER$ = (org.apache.avro.io.DatumWriter<EntityGaze>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<EntityGaze>
    READER$ = (org.apache.avro.io.DatumReader<EntityGaze>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
