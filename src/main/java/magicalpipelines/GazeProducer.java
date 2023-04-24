package magicalpipelines;

import java.io.InputStream;
import java.util.*;

import com.google.common.io.Resources;
import magicalpipelines.model.EntityGaze;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.*;
import org.json.simple.JSONObject;


public class GazeProducer {

    private final static String TOPIC_NAME = "gazes";
    private final static String BOOTSTRAP_SERVERS = "localhost:9092";

    public static void main(String[] args) throws Exception {

        // Read Kafka properties file and create Kafka producer with the given properties
        KafkaProducer<byte[], String> producer;
        try (InputStream props = Resources.getResource("producer.properties").openStream()) {
            Properties properties = new Properties();
            properties.load(props);
            // Create Kafka producer
            producer = new  KafkaProducer<byte[], String>(properties);
        }

        // generate random gaze events
        while (true) {


            JSONObject gaze =  generateRandomGaze();
            byte[] key = null;
            String value = gaze.toJSONString();
            System.out.println("Producing - "+value);
            ProducerRecord<byte[], String> record = new ProducerRecord<>(TOPIC_NAME, key, value);
            producer.send(record);

            Thread.sleep(8);
        }

    }


    public static JSONObject generateRandomGaze() {
        Random rand = new Random();

        long timestamp = System.currentTimeMillis();

        // Generate random x and y positions for left and right gaze points, with a 10% chance of setting the value to -1
        int xposLeft = (rand.nextDouble() < 0.1) ? -1 : rand.nextInt(1920);
        int yposLeft =  (rand.nextDouble() < 0.1) ? -1 : rand.nextInt(1080);
        int xposRight = (rand.nextDouble() < 0.1) ? -1 : rand.nextInt(1920);
        int yposRight =  (rand.nextDouble() < 0.1) ? -1 : rand.nextInt(1080);

        // Determine if the gaze points are valid based on whether the X and Y positions are not -1
        boolean validGazeLeft = xposLeft != -1 && yposLeft != -1;
        boolean validGazeRight = xposRight != -1 && yposRight != -1;

        // Generate pupil size within a small range and add/subtract a small random amount for variation, with a 10% chance of setting the value to -1
        double pupilSize = (rand.nextDouble() * 0.3) + 3.0;
        double pupilSizeLeft = (rand.nextDouble() < 0.1) ? -1 : pupilSize + ((Math.random() * 0.05) - 0.025);
        double pupilSizeRight = (rand.nextDouble() < 0.1) ? -1 : pupilSize + ((Math.random() * 0.05) - 0.025);

        // Determine if the pupil sizes are valid based on whether the pupil sizes are not -1
        boolean validPupilSizeLeft = pupilSizeLeft != -1;
        boolean validPupilSizeRight = pupilSizeRight != -1;

        // Generate random distances (between the user and the eye-tracker) for X, Y, and Z axes
        double xDistance = rand.nextDouble(50, 81);
        double yDistance = rand.nextDouble(50, 81);
        double zDistance = rand.nextDouble(50, 81);

        // Generate a random event source value
        int eventSource = rand.nextInt(5);

        // Generate a random system memory value
        double systemMemory = rand.nextDouble() * 0.1;

        // Create a JSONObject to store the generated gaze data
        JSONObject gaze = new JSONObject();

        // Add the generated values to the JSONObject
        gaze.put("Timestamp", timestamp);
        gaze.put("XposLeft", xposLeft);
        gaze.put("YposLeft", yposLeft);
        gaze.put("XposRight", xposRight);
        gaze.put("YposRight", yposRight);
        gaze.put("ValidGazeLeft", validGazeLeft);
        gaze.put("ValidGazeRight", validGazeRight);
        gaze.put("PupilSizeLeft", pupilSizeLeft);
        gaze.put("PupilSizeRight", pupilSizeRight);
        gaze.put("ValidPupilSizeLeft", validPupilSizeLeft);
        gaze.put("ValidPupilSizeRight", validPupilSizeRight);
        gaze.put("XDistance", xDistance);
        gaze.put("YDistance", yDistance);
        gaze.put("ZDistance", zDistance);
        gaze.put("EventSource", eventSource);
        gaze.put("SystemMemory", systemMemory);

        return gaze;
    }
}