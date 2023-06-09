package magicalpipelines.serialization.json;

import magicalpipelines.serialization.Gaze;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

public class GazeSerdes implements Serde<Gaze> {

  @Override
  public Serializer<Gaze> serializer() {
    return new GazeSerializer();
  }

  @Override
  public Deserializer<Gaze> deserializer() {
    return new GazeDeserializer();
  }
}
