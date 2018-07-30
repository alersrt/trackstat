package org.student.trackstat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {

  /** The car's identifier. */
  @JsonProperty("id")
  private long id;

  /** The car's code. */
  @JsonProperty("code")
  private String code;

  /** Type of transmission is used into the car. */
  @JsonProperty("transmission")
  @JsonSerialize(using = TransmissionSerializer.class)
  @JsonDeserialize(using = TransmissionDeserializer.class)
  private Transmission transmission;

  /** Answer at question "is AI enabled?". */
  @JsonProperty("ai")
  @JsonSerialize(using = CustomBooleanSerializer.class)
  @JsonDeserialize(using = CustomBooleanDeserializer.class)
  private boolean ai;

  /** The maximum speed of the current car at the track. */
  @JsonProperty("max-speed")
  private MeasureUnit maxSpeed;

  /** Defines track to which this information is belong. */
  @JsonIgnore
  private Track track;
}
