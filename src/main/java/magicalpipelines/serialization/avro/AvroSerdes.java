package magicalpipelines.serialization.avro;

import magicalpipelines.model.EntityGaze;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.common.serialization.Serde;

import java.util.Collections;
import java.util.Map;

public class AvroSerdes {

  public static Serde<EntityGaze> EntityGaze(String url, boolean isKey) {
    Map<String, String> serdeConfig = Collections.singletonMap("schema.registry.url", url);
    Serde<EntityGaze> serde = new SpecificAvroSerde<>();
    serde.configure(serdeConfig, isKey);
    return serde;
  }
}
