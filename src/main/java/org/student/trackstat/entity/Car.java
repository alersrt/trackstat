package org.student.trackstat.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;
import org.student.trackstat.model.Transmission;

@Entity
@Data
public class Car {

  @Id
  @Column(name = "id")
  private long id;

  @Column(name = "code")
  private String code;

  @Column(name = "transmission")
  private Transmission transmission;

  @Column(name = "ai")
  private boolean ai;

  @Embedded
  @AttributeOverrides({
    @AttributeOverride(name = "unit", column = @Column(name = "maxSpeedUnit")),
    @AttributeOverride(name = "value", column = @Column(name = "maxSpeedValue"))
  })
  private MeasureUnit maxSpeed;

  @ManyToOne
  private Track track;
}
