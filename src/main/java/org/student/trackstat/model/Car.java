package org.student.trackstat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.student.trackstat.mapper.CustomBooleanDeserializer;
import org.student.trackstat.mapper.CustomBooleanSerializer;
import org.student.trackstat.mapper.TransmissionDeserializer;
import org.student.trackstat.mapper.TransmissionSerializer;

/**
 * Describes car's model in database.
 */
@Entity
@Table(name = "car")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {

  /** The car's identifier. */
  @Id
  @Column(name = "id", nullable = false)
  @JsonProperty("id")
  private long id;

  /** The car's code. */
  @Column(name = "code")
  @JsonProperty("code")
  private String code;

  /** Type of transmission is used into the car. */
  @Column(name = "transmission")
  @JsonProperty("transmission")
  @JsonSerialize(using = TransmissionSerializer.class)
  @JsonDeserialize(using = TransmissionDeserializer.class)
  private Transmission transmission;

  /** Answer at question "is AI enabled?". */
  @Column(name = "ai")
  @JsonProperty("ai")
  @JsonSerialize(using = CustomBooleanSerializer.class)
  @JsonDeserialize(using = CustomBooleanDeserializer.class)
  private boolean ai;

  /** The maximum speed of the current car at the track. */
  @Embedded
  @AttributeOverrides({
    @AttributeOverride(name = "unit", column = @Column(name = "maxSpeedUnit")),
    @AttributeOverride(name = "value", column = @Column(name = "maxSpeedValue"))
  })
  @JsonProperty("max-speed")
  private MeasureUnit maxSpeed;

  /** Defines track to which this information is belong. */
  @ManyToOne
  @JsonIgnore
  private Track track;
}
