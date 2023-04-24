package magicalpipelines.language;

import io.netty.util.internal.ThreadLocalRandom;
import magicalpipelines.model.EntityGaze;
import magicalpipelines.serialization.Gaze;

import java.util.ArrayList;
import java.util.List;

public class ETClient implements LanguageClient {

  @Override
  public List<EntityGaze> getEntityGaze(Gaze gaze) {
    List<EntityGaze> results = new ArrayList<>();


    EntityGaze entityGaze =
            EntityGaze.newBuilder()
                    .setTimestamp(gaze.getTimestamp())
                    .setXpos(gaze.getXpos())
                    .setYpos(gaze.getYpos())
                    .setPupilSize(gaze.getPupilSize())
                    .setAOI(gaze.getAoi())
                    .build();

    results.add(entityGaze);

    return results;
  }

  Double randomDouble() {
    return ThreadLocalRandom.current().nextDouble(0, 1);
  }
}
