package org.student.trackstat.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Describes measure units which can be used in for car's speed ot track's length description.
 */
@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class MeasureUnit {

  /** Unit of the measurement. */
  @Column(name = "unit")
  @NonNull
  private String unit;

  /** The current value. */
  @Column(name = "value")
  @NonNull
  private double value;
}
