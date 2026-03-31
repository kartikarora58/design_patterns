package kafka_multi.model;

public class ConsumerTopic {
    public Topic topic;
    public int offset;

    public ConsumerTopic(Topic topic)
    {
        this.topic = topic;
        this.offset = 0;
    }

}
