package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the SensorData type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "SensorData", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class SensorData implements Model {
  public static final QueryField ID = field("SensorData", "id");
  public static final QueryField VALUE = field("SensorData", "value");
  public static final QueryField DATE = field("SensorData", "date");
  public static final QueryField TIME = field("SensorData", "time");
  public static final QueryField COMMENT = field("SensorData", "comment");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="Float", isRequired = true) Double value;
  private final @ModelField(targetType="String", isRequired = true) String date;
  private final @ModelField(targetType="String", isRequired = true) String time;
  private final @ModelField(targetType="String", isRequired = true) String comment;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public Double getValue() {
      return value;
  }
  
  public String getDate() {
      return date;
  }
  
  public String getTime() {
      return time;
  }
  
  public String getComment() {
      return comment;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private SensorData(String id, Double value, String date, String time, String comment) {
    this.id = id;
    this.value = value;
    this.date = date;
    this.time = time;
    this.comment = comment;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      SensorData sensorData = (SensorData) obj;
      return ObjectsCompat.equals(getId(), sensorData.getId()) &&
              ObjectsCompat.equals(getValue(), sensorData.getValue()) &&
              ObjectsCompat.equals(getDate(), sensorData.getDate()) &&
              ObjectsCompat.equals(getTime(), sensorData.getTime()) &&
              ObjectsCompat.equals(getComment(), sensorData.getComment()) &&
              ObjectsCompat.equals(getCreatedAt(), sensorData.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), sensorData.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getValue())
      .append(getDate())
      .append(getTime())
      .append(getComment())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("SensorData {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("value=" + String.valueOf(getValue()) + ", ")
      .append("date=" + String.valueOf(getDate()) + ", ")
      .append("time=" + String.valueOf(getTime()) + ", ")
      .append("comment=" + String.valueOf(getComment()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static ValueStep builder() {
      return new Builder();
  }
  
  /**
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static SensorData justId(String id) {
    return new SensorData(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      value,
      date,
      time,
      comment);
  }
  public interface ValueStep {
    DateStep value(Double value);
  }
  

  public interface DateStep {
    TimeStep date(String date);
  }
  

  public interface TimeStep {
    CommentStep time(String time);
  }
  

  public interface CommentStep {
    BuildStep comment(String comment);
  }
  

  public interface BuildStep {
    SensorData build();
    BuildStep id(String id);
  }
  

  public static class Builder implements ValueStep, DateStep, TimeStep, CommentStep, BuildStep {
    private String id;
    private Double value;
    private String date;
    private String time;
    private String comment;
    @Override
     public SensorData build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new SensorData(
          id,
          value,
          date,
          time,
          comment);
    }
    
    @Override
     public DateStep value(Double value) {
        Objects.requireNonNull(value);
        this.value = value;
        return this;
    }
    
    @Override
     public TimeStep date(String date) {
        Objects.requireNonNull(date);
        this.date = date;
        return this;
    }
    
    @Override
     public CommentStep time(String time) {
        Objects.requireNonNull(time);
        this.time = time;
        return this;
    }
    
    @Override
     public BuildStep comment(String comment) {
        Objects.requireNonNull(comment);
        this.comment = comment;
        return this;
    }
    
    /**
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, Double value, String date, String time, String comment) {
      super.id(id);
      super.value(value)
        .date(date)
        .time(time)
        .comment(comment);
    }
    
    @Override
     public CopyOfBuilder value(Double value) {
      return (CopyOfBuilder) super.value(value);
    }
    
    @Override
     public CopyOfBuilder date(String date) {
      return (CopyOfBuilder) super.date(date);
    }
    
    @Override
     public CopyOfBuilder time(String time) {
      return (CopyOfBuilder) super.time(time);
    }
    
    @Override
     public CopyOfBuilder comment(String comment) {
      return (CopyOfBuilder) super.comment(comment);
    }
  }
  
}
