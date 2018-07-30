package org.student.trackstat.entity;

import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Track {

  @Id
  @Column(name = "id")
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Embedded
  @AttributeOverrides({
    @AttributeOverride(name = "unit", column = @Column(name = "lengthUnit")),
    @AttributeOverride(name = "value", column = @Column(name = "lengthValue"))
  })
  private MeasureUnit length;

  @OneToMany
  private List<Car> cars;
}
