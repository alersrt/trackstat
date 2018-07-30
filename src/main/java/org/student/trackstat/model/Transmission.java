package org.student.trackstat.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/** Class is described car's transmission. */
public enum Transmission {
  AUTOMATIC("automatic"),
  MANUAL("manual");

  /** Stores mapping of enum to values of {@link #name} fields. */
  private static final Map<String, Transmission> ENUM_MAP;

  /* Initializes {@link #ENUM_MAP} by values. */
  static {
    ENUM_MAP = Collections.unmodifiableMap(Arrays.stream(Transmission.values())
      .collect(Collectors.toMap(Transmission::toString, e -> e, (e1, e2) -> e1, ConcurrentHashMap::new)));
  }

  /** Readable name of this enum. */
  private String name;

  /**
   * Constructor for enum.
   *
   * @param name value of the enum's name.
   */
  Transmission(String name) {
    this.name = name;
  }

  /**
   * Returns enum by value of its {@link #name} field.
   *
   * @param name name of enum.
   * @return enum value.
   */
  public static Transmission get(String name) {
    return ENUM_MAP.get(name);
  }

  /** {@inheritDoc} */
  @Override
  public String toString() {
    return name;
  }
}
