# KafkaSimple

Project demonstrates simple usage for Kafka by using Producer to send events, and Consumer to receive events.

### Steps to test:
- start the kafka environment
  >bin/zookeeper-server-start.sh config/zookeeper.properties
  
  >'bin/kafka-server-start.sh config/server.properties
- create a topic named *test1* to store your events
  >bin/kafka-topics.sh --create --topic test1 --bootstrap-server localhost:9092

[Kafka quickstart](https://kafka.apache.org/quickstart)

- Run Producer to send events
- Run Consumer to get events