package org.student.trackstat.mapper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import org.student.trackstat.model.Car;

public class CustomCarSerializer extends StdSerializer<Car> {

  public CustomCarSerializer() {
    this(null);
  }

  protected CustomCarSerializer(Class<Car> t) {
    super(t);
  }

  @Override
  public void serialize(Car value, JsonGenerator gen, SerializerProvider provider) throws IOException {
    gen.writeStartObject();
    gen.writeNumberField("id", value.getId());
    gen.writeStringField("code", value.getCode());
    gen.writeStringField("transmission", value.getTransmission().toString());
    gen.writeStringField("ai", value.isAi() ? "enabled" : "disabled");
    gen.writeObjectField("max-speed", value.getMaxSpeed());
    gen.writeEndObject();
  }
}
