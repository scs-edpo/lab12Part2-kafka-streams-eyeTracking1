echo "Waiting for Kafka to come online..."
cub kafka-ready -b kafka:9092 1 20

kafka-topics \
  --bootstrap-server kafka:9092 \
  --topic gazes \
  --replication-factor 1 \
  --partitions 1 \
  --create

kafka-topics \
  --bootstrap-server kafka:9092 \
  --topic gazes-out \
  --replication-factor 1 \
  --partitions 2 \
  --create

sleep infinity
