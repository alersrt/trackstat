package org.student.trackstat.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;

/**
 * Describes measure units which can be used in for car's speed ot track's length description.
 */
@Embeddable
@Data
public class MeasureUnit implements Serializable {

  /** Unit of the measurement. */
  @Column(name = "unit")
  private String unit;

  /** The current value. */
  @Column(name = "value")
  private double value;
}
