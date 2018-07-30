package org.student.trackstat;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.java.Log;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.student.trackstat.model.Car;
import org.student.trackstat.model.Car.Transmission;
import org.student.trackstat.model.MeasureUnit;
import org.student.trackstat.model.Track;

@Log
@Tag("unit")
@DisplayName("Unit-test for JSON serializer/deserializer")
class JsonMapperTest {

  @DisplayName("Car: serializer")
  @Test
  void carMapper_serialize() throws IOException {
    /*------ Arranges ------*/
    ObjectMapper mapper = new ObjectMapper();

    Car inputObject = Car.builder()
      .id(2)
      .code("rdb1")
      .transmission(Transmission.AUTOMATIC)
      .ai(true)
      .maxSpeed(new MeasureUnit("mps", 110.12121212))
      .build();

    String expectedJson = "{\"id\":2,"
      + "\"code\":\"rdb1\","
      + "\"transmission\":\"automatic\","
      + "\"ai\":\"enabled\","
      + "\"max-speed\":{\"unit\":\"mps\",\"value\":110.12121212}}";

    /*------ Actions ------*/
    String actualJson = mapper.writeValueAsString(inputObject);
    log.info(actualJson);

    /*------ Asserts ------*/
    assertThat(actualJson).isEqualTo(expectedJson);
  }

  @DisplayName("Car: deserializer")
  @Test
  void carMapper_deserialize() throws IOException {
    /*------ Arranges ------*/
    ObjectMapper mapper = new ObjectMapper();

    String inputJson = "{\n"
      + "\t\t\t\"id\": \"2\",\n"
      + "\t\t\t\"code\": \"rdb1\",\n"
      + "\t\t\t\"transmission\": \"automatic\",\n"
      + "\t\t\t\"ai\": \"enabled\",\n"
      + "\t\t\t\"max-speed\": {\n"
      + "\t\t\t\t\"unit\": \"mps\",\n"
      + "\t\t\t\t\"value\": 110.12121212\n"
      + "\t\t\t}\n"
      + "\t\t}";

    Car expectedObject = Car.builder()
      .id(2)
      .code("rdb1")
      .transmission(Transmission.AUTOMATIC)
      .ai(true)
      .maxSpeed(new MeasureUnit("mps", 110.12121212))
      .build();

    /*------ Actions ------*/
    Car actualObject = mapper.readValue(inputJson, Car.class);
    log.info(actualObject.toString());

    /*------ Asserts ------*/
    assertThat(actualObject).isEqualTo(expectedObject);
  }

  @DisplayName("Track: serializer")
  @Test
  void trackMapper_serialize() throws JsonProcessingException {
    /*------ Arranges ------*/
    ObjectMapper mapper = new ObjectMapper();

    List<Car> cars = new ArrayList<>();
    cars.add(Car.builder()
      .id(2)
      .code("rdb1")
      .transmission(Transmission.AUTOMATIC)
      .ai(true)
      .maxSpeed(new MeasureUnit("mps", 110.12121212))
      .build());
    cars.add(Car.builder()
      .id(1)
      .code("rdb3")
      .transmission(Transmission.AUTOMATIC)
      .ai(false)
      .maxSpeed(new MeasureUnit("mps", 120.967))
      .build());

    Track inputObject = Track.builder()
      .id(1)
      .name("Millbrook")
      .description("Millbrook city course race track")
      .length(new MeasureUnit("km", 7.4))
      .cars(cars)
      .build();

    String expectedJson = "{"
      + "\"id\":1,"
      + "\"name\":\"Millbrook\","
      + "\"description\":\"Millbrook city course race track\","
      + "\"length\":{\"unit\":\"km\",\"value\":7.4},"
      + "\"cars\":[{"
      + "\"id\":\"2\","
      + "\"code\":\"rdb1\","
      + "\"transmission\":\"automatic\","
      + "\"ai\":\"enabled\","
      + "\"max-speed\":{\"unit\":\"mps\",\"value\":110.12121212}"
      + "},{"
      + "\"id\":\"1\","
      + "\"code\":\"rdb3\","
      + "\"transmission\":\"automatic\","
      + "\"ai\":\"disabled\","
      + "\"max-speed\":{\"unit\":\"mps\",\"value\":120.967}"
      + "}"
      + "]}";

    /*------ Actions ------*/
    String actualJson = mapper.writeValueAsString(inputObject);
    log.info(actualJson);

    /*------ Asserts ------*/
    assertThat(actualJson).isEqualTo(expectedJson);
  }

  @DisplayName("Track: deserializer")
  @Test
  void trackMapper_deserialize() throws IOException {
    /*------ Arranges ------*/
    ObjectMapper mapper = new ObjectMapper();

    String inputJson = "{\n"
      + "\t\t\"id\": 1,\n"
      + "\t\t\"name\": \"Millbrook\",\n"
      + "\t\t\"description\": \"Millbrook city course race track\",\n"
      + "\t\t\"length\": {\n"
      + "\t\t\t\"unit\": \"km\",\n"
      + "\t\t\t\"value\": 7.4\n"
      + "\t\t},\n"
      + "\t\t\"cars\": [{\n"
      + "\t\t\t\"id\": \"2\",\n"
      + "\t\t\t\"code\": \"rdb1\",\n"
      + "\t\t\t\"transmission\": \"automatic\",\n"
      + "\t\t\t\"ai\": \"enabled\",\n"
      + "\t\t\t\"max-speed\": {\n"
      + "\t\t\t\t\"unit\": \"mps\",\n"
      + "\t\t\t\t\"value\": 110.12121212\n"
      + "\t\t\t}\n"
      + "\t\t}, {\n"
      + "\t\t\t\"id\": \"1\",\n"
      + "\t\t\t\"code\": \"rdb3\",\n"
      + "\t\t\t\"transmission\": \"automatic\",\n"
      + "\t\t\t\"ai\": \"disabled\",\n"
      + "\t\t\t\"max-speed\": {\n"
      + "\t\t\t\t\"unit\": \"mps\",\n"
      + "\t\t\t\t\"value\": 120.967\n"
      + "\t\t\t}\n"
      + "\t\t}]\n"
      + "\t}";

    List<Car> cars = new ArrayList<>();
    cars.add(Car.builder()
      .id(2)
      .code("rdb1")
      .transmission(Transmission.AUTOMATIC)
      .ai(true)
      .maxSpeed(new MeasureUnit("mps", 110.12121212))
      .build());
    cars.add(Car.builder()
      .id(1)
      .code("rdb3")
      .transmission(Transmission.AUTOMATIC)
      .ai(false)
      .maxSpeed(new MeasureUnit("mps", 120.967))
      .build());

    Track expectedObject = Track.builder()
      .id(1)
      .name("Millbrook")
      .description("Millbrook city course race track")
      .length(new MeasureUnit("km", 7.4))
      .cars(cars)
      .build();

    /*------ Actions ------*/
    Track actualObject = mapper.readValue(inputJson, Track.class);
    log.info(actualObject.toString());

    /*------ Asserts ------*/
    assertThat(actualObject).isEqualTo(expectedObject);
  }
}
