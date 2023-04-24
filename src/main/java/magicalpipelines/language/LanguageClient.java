package magicalpipelines.language;

import magicalpipelines.model.EntityGaze;
import magicalpipelines.serialization.Gaze;

import java.util.List;

public interface LanguageClient {

  public List<EntityGaze> getEntityGaze(Gaze gaze);
}
