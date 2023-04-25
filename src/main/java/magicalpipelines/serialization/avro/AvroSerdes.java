package magicalpipelines.serialization.avro;

import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import magicalpipelines.model.AvroGaze;
import org.apache.kafka.common.serialization.Serde;

import java.util.Collections;
import java.util.Map;

public class AvroSerdes {

  public static Serde<AvroGaze> avroGaze(String url, boolean isKey) {
    Map<String, String> serdeConfig = Collections.singletonMap("schema.registry.url", url);
    Serde<AvroGaze> serde = new SpecificAvroSerde<>();
    serde.configure(serdeConfig, isKey);
    return serde;
  }
}
