package org.student.trackstat.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import lombok.Data;
import org.student.trackstat.mapper.CustomCarDeserializer;
import org.student.trackstat.mapper.CustomCarSerializer;

/**
 * Describes car's model in database.
 */
@JsonSerialize(using = CustomCarSerializer.class)
@JsonDeserialize(using = CustomCarDeserializer.class)
@Data
public class Car {

  /** The car's identifier. */
  private long id;

  /** The car's code. */
  private String code;

  /** Type of transmission is used into the car. */
  private Transmission transmission;

  /** Answer at question "is AI enabled?". */
  private boolean ai;

  /** The maximum speed of the current car at the track. */
  private MeasureUnit maxSpeed;

  /** Defines track to which this information is belong. */
  private Track track;

  /** Class is described car's transmission. */
  public enum Transmission {
    AUTOMATIC("automatic"),
    MANUAL("manual");

    private static final Map<String, Transmission> ENUM_MAP;

    static {
      ENUM_MAP = Collections.unmodifiableMap(Arrays.stream(Transmission.values())
        .collect(Collectors.toMap(Transmission::toString, e -> e, (e1, e2) -> e1, ConcurrentHashMap::new)));
    }

    private String name;

    Transmission(String name) {
      this.name = name;
    }

    public static Transmission get(String name) {
      return ENUM_MAP.get(name);
    }

    @Override
    public String toString() {
      return name;
    }
  }
}
