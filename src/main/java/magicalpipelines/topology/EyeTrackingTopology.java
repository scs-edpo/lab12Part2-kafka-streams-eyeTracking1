package magicalpipelines.topology;

import magicalpipelines.model.EntityGaze;

import magicalpipelines.language.ETClient;
import magicalpipelines.language.LanguageClient;
import magicalpipelines.partitioner.CustomPartitioner;
import magicalpipelines.serialization.Gaze;
import magicalpipelines.serialization.avro.AvroSerdes;
import magicalpipelines.serialization.json.GazeSerdes;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.*;

import magicalpipelines.utils.Utils;

import java.util.Arrays;
import java.util.List;

public class EyeTrackingTopology {
  private static final List<String> currencies = Arrays.asList("bitcoin", "ethereum");

  public static Topology build() {

    return build(new ETClient());
  }


  public static Topology build(LanguageClient languageClient) {

    // the builder is used to construct the topology
    StreamsBuilder builder = new StreamsBuilder();

    // start streaming gazes using our custom value serdes.
    KStream<byte[], Gaze> stream =
        builder.stream("gazes", Consumed.with(Serdes.ByteArray(), new GazeSerdes()));
    stream.print(Printed.<byte[], Gaze>toSysOut().withLabel("gazes-stream"));

    // Apply content filter to gazes // Keep only relevant attributes
      KStream<byte[], Gaze> contentFilteredGazes =
              stream.mapValues(
                  (gaze) -> {
                      Gaze contentFilteredGaze = new Gaze();
                      contentFilteredGaze.setTimestamp(gaze.getTimestamp());
                      contentFilteredGaze.setXposLeft(gaze.getXposLeft());
                      contentFilteredGaze.setYposLeft(gaze.getYposLeft());
                      contentFilteredGaze.setXposRight(gaze.getXposRight());
                      contentFilteredGaze.setYposRight(gaze.getYposRight());
                      contentFilteredGaze.setValidGazeLeft(gaze.isValidGazeLeft());
                      contentFilteredGaze.setValidGazeRight(gaze.isValidGazeRight());
                      contentFilteredGaze.setPupilSizeLeft(gaze.getPupilSizeLeft());
                      contentFilteredGaze.setPupilSizeRight(gaze.getPupilSizeRight());
                      contentFilteredGaze.setValidPupilSizeLeft(gaze.isValidPupilSizeLeft());
                      contentFilteredGaze.setValidPupilSizeRight(gaze.isValidPupilSizeRight());
                      return contentFilteredGaze;
                              });


      // Apply event filter to gazes
      // Keep only gazes with valid ValidGazeLeft, ValidGazeRight, ValidPupilSizeLeft, ValidPupilSizeRight
      KStream<byte[], Gaze> eventFilteredGazes =
            contentFilteredGazes.filter(
            (key, gaze) -> {
              return (gaze.isValidGazeLeft() && gaze.isValidGazeRight() && gaze.isValidPupilSizeLeft() && gaze.isValidPupilSizeRight() );
            });

      // Apply event translator
      // compute xpos from xposLeft and xposRight
      // compute ypos from yposLeft and yposRight
      // compute pupilSize from pupilSizeLeft and pupilSizeRight
      // find AOI based on xpos and ypos
      KStream<byte[], Gaze> eventTranslatedGazes =
              eventFilteredGazes.mapValues(
                  (gaze) -> {
                      Gaze eventFilteredGaze = new Gaze();
                      eventFilteredGaze.setTimestamp(gaze.getTimestamp());
                      eventFilteredGaze.setPupilSize((gaze.getPupilSizeLeft()+gaze.getPupilSizeRight())/2);
                      eventFilteredGaze.setXpos((gaze.getXposLeft()+gaze.getXposRight())/2);
                      eventFilteredGaze.setYpos((gaze.getYposLeft()+gaze.getYposRight())/2);
                      eventFilteredGaze.setAoi(Utils.findAOI(eventFilteredGaze.getXpos(),eventFilteredGaze.getYpos()));
                      return eventFilteredGaze;
                      });

      // Apply event router
      // For sake of simulation divide gazes into two gazeBranches based on pupilSizeThreshold
      // gazes with pupil size less than pupilSizeThreshold are assumed to reflect low cognitive load, while the other gazes are assumed to reflect high cognitive load
      double pupilSizeThreshold = 3.15;
      KStream<byte[], Gaze>[] gazeBranches = eventTranslatedGazes.branch(
              (k, gaze) -> gaze.getPupilSize() < pupilSizeThreshold,
              (k, gaze) -> gaze.getPupilSize() >= pupilSizeThreshold);

    // Route gazeBranches to different partitions of the same topic and process them
          for (int i = 0; i < gazeBranches.length; i++) {

              // select branch
              KStream<byte[], Gaze> branch = gazeBranches[i];

              // Process the data in the branch (e.g., using languageClient.getEntityGaze)
              KStream<byte[], EntityGaze> dataToStream = branch.flatMapValues(
                      (gaze) -> {
                          List<EntityGaze> results = languageClient.getEntityGaze(gaze);
                          return results;
                      });

              // Create a new key based on the partitioning condition
              int fi = i;
              KStream<String, EntityGaze> keyedStream = dataToStream.selectKey((key, value) -> {
                  if (fi==0) {
                      return "low CL";
                  } else {
                      return "high CL";
                  }
              });

              // Write to the output topic
                  keyedStream.to(
                          "gazes-out",
                          Produced.with(
                                  Serdes.String(),
                                  AvroSerdes.EntityGaze("http://localhost:8081", false),
                                  new CustomPartitioner()));
          }



    return builder.build();
  }
}
