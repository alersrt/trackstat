package org.student.trackstat;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import lombok.extern.java.Log;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.student.trackstat.model.Car;
import org.student.trackstat.model.Car.Transmission;
import org.student.trackstat.model.MeasureUnit;

@Log
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
}
