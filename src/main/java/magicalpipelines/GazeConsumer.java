package magicalpipelines;

import com.google.common.io.Resources;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import magicalpipelines.model.AvroGaze;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;


public class GazeConsumer {

    public static void main(String[] args) throws IOException {

            // Read Kafka properties file and create Kafka consumer with the given properties
            KafkaConsumer<String, AvroGaze> consumer;
            try (InputStream props = Resources.getResource("consumer.properties").openStream()) {
                Properties properties = new Properties();
                properties.load(props);
                consumer = new KafkaConsumer<>(properties);
            }

            // subscribe to relevant topics
            consumer.subscribe(Arrays.asList("gazes-out"));


            while (true) {

                // pool new data
                ConsumerRecords<String, AvroGaze> records = consumer.poll(Duration.ofMillis(8));

                // process consumer records
                for (ConsumerRecord<String, AvroGaze> record : records) {

                            String value = record.value().toString();
                            String cl = record.partition()==1? "High": "Low";
                            System.out.println("Received event: " + value + "- Cognitive load: " + cl);


                    }
                }


            }
        }



