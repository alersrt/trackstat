package org.student.trackstat.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Describes measure units which can be used in for car's speed ot track's length description.
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class MeasureUnit {

  /** Unit of the measurement. */
  @NonNull
  private String unit;

  /** The current value. */
  @NonNull
  private double value;
}
