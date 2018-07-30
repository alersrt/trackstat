package org.student.trackstat.mapper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;

public class CustomBooleanSerializer extends StdSerializer<Boolean> {

  public CustomBooleanSerializer() {
    this(null);
  }

  protected CustomBooleanSerializer(Class<Boolean> t) {
    super(t);
  }

  @Override
  public void serialize(Boolean value, JsonGenerator gen, SerializerProvider provider) throws IOException {
    gen.writeString(value ? "enabled" : "disabled");
  }
}
