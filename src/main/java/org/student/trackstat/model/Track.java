package org.student.trackstat.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Describes track's model in database.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Track {

  /** The track identifier. */
  private long id;

  /** The track's name. */
  private String name;

  /** The track's description. */
  private String description;

  /** The length of the current track. */
  @JsonProperty("length")
  private MeasureUnit length;

  /** A car's list which contains all cars which are belong to this track. */
  @JsonProperty("cars")
  private List<Car> cars;
}
