package org.student.trackstat.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;

public class CustomBooleanDeserializer extends StdDeserializer<Boolean> {

  public CustomBooleanDeserializer() {
    this(null);
  }

  protected CustomBooleanDeserializer(Class<?> vc) {
    super(vc);
  }

  @Override
  public Boolean deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    ObjectCodec codec = p.getCodec();
    JsonNode node = codec.readTree(p);

    return node.asText().equals("enabled");
  }
}
