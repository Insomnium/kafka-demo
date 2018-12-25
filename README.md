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
