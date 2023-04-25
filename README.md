# lab12Part2-kafka-streams-eyeTracking1

This lab simulates the generation, processing, and consumption of gaze data. 
The gaze data contains information about the position of the eyes and the size of the pupils. 
The project consists of three main components: a gaze producer, an event processing topology, and a gaze consumer. 

The lab is based on https://github.com/scs-edpo/lab12Part1-kafka-streams-cryptosentiment. 
Only the new concepts are introduced.

## Running the Project

1. Open a terminal/command prompt and navigate to the project's root directory.
2. Run `docker-compose up` to start the Kafka broker, Zookeeper, and the schema registry.
3. Run the [EventProcessingApp](/src/main/java/magicalpipelines/EventProcessingApp.java)  to process the gaze data and apply various filters and transformations.
4. Run the [GazeConsumer](/src/main/java/magicalpipelines/GazeConsumer.java) to consume the processed gaze data.
5. In IntelliJ, run the [GazeProducer](/src/main/java/magicalpipelines/GazeProducer.java) to start generating gaze data.


## Producing events

The [GazeProducer](/src/main/java/magicalpipelines/GazeProducer.java) class is meant for generating random gaze events and sending them to a Kafka topic. The main steps in this class are:

1. Initialize Kafka producer with properties from the `producer.properties` file.
2. Generate random gaze events using the `generateRandomGaze()` method.
3. Send generated gaze events to the "gazes" Kafka topic.

## Events processing

[EventProcessingApp](/src/main/java/magicalpipelines/EventProcessingApp.java) uses the [EyeTrackingTopology](/src/main/java/magicalpipelines/topology/EyeTrackingTopology.java) class which  is meant for processing raw gaze data by filtering, transforming, and routing the data through a series of operations.

### Topology

The steps of the topology (2-5) are illustrated in the following [PDF file](doc/eventsProcessingPipeline.pdf).

### Control-flow Summary

1. **Stream Gazes**: A stream of gaze data is created by reading from the "gazes" Kafka topic using the `GazeSerdes` custom Serde for deserialization.

2. **Content Filtering**: The content of each gaze is filtered by keeping only relevant attributes, discarding unnecessary data. This step produces a new stream called `contentFilteredGazes`.

3. **Event Filtering**: The event filtering step removes gazes with invalid gaze or pupil size data by checking the `ValidGazeLeft`, `ValidGazeRight`, `ValidPupilSizeLeft`, and `ValidPupilSizeRight` fields. The resulting stream is called `eventFilteredGazes`.

4. **Event Translation**: In this step, gaze data is transformed by:
    - Calculating the average x and y gaze positions based on the left and right gaze points using the `calculateAverageLeftRightReading(double leftValue, double rightValue)` method in [Processor](/src/main/java/magicalpipelines/gazeprocessing/Processor.java).
    - Calculating the average pupil size based on the left and right pupil sizes using the `calculateAverageLeftRightReading(double leftValue, double rightValue)` method in [Processor](/src/main/java/magicalpipelines/gazeprocessing/Processor.java).
    - Determining the Area of Interest (AOI) using the `findAOI(double xPos, double yPos)` method in [Processor](/src/main/java/magicalpipelines/gazeprocessing/Processor.java).

   The new stream with these computed attributes is called `eventTranslatedGazes`.

5. **Event Routing**: This step simulates the division of gaze data into two branches based on pupil size. Gazes with a pupil size below the `pupilSizeThreshold` are assumed to reflect low cognitive load, while those with a pupil size equal to or above the threshold are assumed to reflect high cognitive load.

6. **Object Transformation**:  transform Gaze objects to AvroGaze objects to allow the Avro serialization

7. **Key Selection**: A new key is created for each processed gaze event based on the routing condition in Step 5 (low or high cognitive load).

8. **Output Topic**: The gaze data is written to the "gazes-out" Kafka topic using the Avro Serde with Schema Registry. `CustomPartitioner` ensures that the gaze events are sent into different partitions based on their key (defined in Step 7).

## Consuming events

The [GazeConsumer](/src/main/java/magicalpipelines/GazeConsumer.java)  class is meant for consuming the processed gaze events from a Kafka topic. The main steps in this class are:

1. Initialize Kafka consumer with properties from the `consumer.properties` file.
2. Subscribe to the "gazes-out" Kafka topic.
3. Continuously poll for new records, process them, and display the results.

## Exercise

1. Explore the different classes of the project and examine the provided implementation. 
2. Try to extend the provided implementation such that the gaze events mapped to each distinct AOI go to a different partition of a new topic.

