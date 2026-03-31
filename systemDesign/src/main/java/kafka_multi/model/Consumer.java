package kafka_multi.model;

public class Consumer {
    int id;
    public String name;
    public ConsumerTopic consumerTopic;

    public Consumer(String name,ConsumerTopic consumerTopic)
    {
        this.name = name;
        this.consumerTopic = consumerTopic;

    }
}
