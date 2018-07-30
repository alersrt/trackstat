package org.student.trackstat.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Describes track's model in database.
 */
@Entity
@Table(name = "track")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Track {

  /** The track identifier. */
  @Id
  @Column(name = "id", nullable = false)
  @JsonProperty("id")
  private long id;

  /** The track's name. */
  @Column(name = "name")
  @JsonProperty("name")
  private String name;

  /** The track's description. */
  @Column(name = "description")
  @JsonProperty("description")
  private String description;

  /** The length of the current track. */
  @Embedded
  @AttributeOverrides({
    @AttributeOverride(name = "unit", column = @Column(name = "lengthUnit")),
    @AttributeOverride(name = "value", column = @Column(name = "lengthValue"))
  })
  @JsonProperty("length")
  private MeasureUnit length;

  /** A car's list which contains all cars which are belong to this track. */
  @OneToMany(cascade = CascadeType.ALL)
  @JsonProperty("cars")
  private List<Car> cars;
}
