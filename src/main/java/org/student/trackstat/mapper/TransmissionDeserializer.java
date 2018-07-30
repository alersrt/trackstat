package org.student.trackstat.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import org.student.trackstat.model.Transmission;

public class TransmissionDeserializer extends StdDeserializer<Transmission> {

  public TransmissionDeserializer() {
    this(null);
  }

  protected TransmissionDeserializer(Class<?> vc) {
    super(vc);
  }

  @Override
  public Transmission deserialize(JsonParser p, DeserializationContext ctxt)
    throws IOException, JsonProcessingException {
    ObjectCodec codec = p.getCodec();
    JsonNode node = codec.readTree(p);

    return Transmission.get(node.asText());
  }
}
