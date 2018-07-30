package org.student.trackstat.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import org.student.trackstat.model.Car;
import org.student.trackstat.model.Car.Transmission;
import org.student.trackstat.model.MeasureUnit;

public class CustomCarDeserializer extends StdDeserializer<Car> {

  public CustomCarDeserializer() {
    this(null);
  }

  protected CustomCarDeserializer(Class<?> vc) {
    super(vc);
  }

  @Override
  public Car deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
    throws IOException, JsonProcessingException {

    ObjectCodec codec = jsonParser.getCodec();
    JsonNode node = codec.readTree(jsonParser);

    long id = node.get("id").asLong();
    String code = node.get("code").asText();
    boolean ai = node.get("ai").asText().equals("enabled");
    MeasureUnit maxSpeed = new MeasureUnit(node.get("max-speed").get("unit").asText(),
      node.get("max-speed").get("value").asDouble());
    Transmission transmission = Transmission.get(node.get("transmission").asText());

    return Car.builder().id(id).code(code).ai(ai).maxSpeed(maxSpeed).transmission(transmission).build();
  }
}
