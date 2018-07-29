package org.student.trackstat.model;

import java.util.List;
import lombok.Data;

/**
 * Describes track's model in database.
 */
@Data
public class Track {

  /** The track identifier. */
  private long id;

  /** The track's name. */
  private String name;

  /** The track's description. */
  private String description;

  /** The length of the current track. */
  private MeasureUnit length;

  /** A car's list which contains all cars which are belong to this track. */
  private List<Car> cars;
}
