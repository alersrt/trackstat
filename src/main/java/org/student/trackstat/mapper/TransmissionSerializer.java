package org.student.trackstat.mapper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import org.student.trackstat.model.Car.Transmission;

public class TransmissionSerializer extends StdSerializer<Transmission> {

  public TransmissionSerializer() {
    this(null);
  }

  protected TransmissionSerializer(Class<Transmission> t) {
    super(t);
  }

  @Override
  public void serialize(Transmission value, JsonGenerator gen, SerializerProvider provider) throws IOException {
    gen.writeString(value.toString());
  }
}
