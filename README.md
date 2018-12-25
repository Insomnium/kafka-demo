# Setup kafka

* see official docs for running Zookeeper and Brokers
* create two topics:
```bash
./kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 3 --partitions 3 --topic limits
```

```bash
./kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 3 --partitions 3 --topic limits-log
```

# Setup mongo
Run as docker container for instance

# Run application
...

# Help
See spring-cloud-stream & spring-kafka-streams docs

# Sample

Push few messages to 'limits' kafka topic:
* Connect to topic with console producer:
```bash
./kafka-console-producer.sh --broker-list localhost:9092 --topic limits
```
* Push few messages like:
    * `{ "type": "CHANGED", "account": "00000000000000000000", "min": 0, "max": 1000000 }`
    * `{ "type": "CHANGED", "account": "00000000000000000000", "min": 0, "max": 1000001 }`
    * `{ "type": "CHANGED", "account": "00000000000000000001", "min": 0, "max": 999999 }`
    
* See log events on 'limits-log' topic with console consumer:
```bash
./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic limits-log
```
