echo "Waiting for Kafka to come online..."
cub kafka-ready -b kafka:9092 1 20

kafka-topics --create --bootstrap-server 'kafka:9092' --topic 'gazes' --replication-factor '1' --partitions '1'

kafka-topics --create --bootstrap-server 'kafka:9092' --topic 'gazes-out' --replication-factor '1' --partitions '2'

sleep infinity
