package kafka;

import kafka.topic.Topic;

public class SubscribedTopic {
    Topic topic_;
    int offset;

    public SubscribedTopic(Topic topic, int offset) {
        this.topic_ = topic;
        this.offset = offset;
    }

    public Topic getTopic() {
        return topic_;
    }

    public void setTopic(Topic topic) {
        topic_ = topic;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
