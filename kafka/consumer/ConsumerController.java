package kafka.consumer;

import kafka.SubscribedTopic;
import kafka.topic.Topic;
import kafka.topic.TopicController;

public class ConsumerController {
    ConsumerRepository consumerRepository_;
    TopicController topicController_;

    public ConsumerController(ConsumerRepository consumerRepository, TopicController topicController)
    {
        this.consumerRepository_ = consumerRepository;
        this.topicController_ = topicController;
    }

    public Consumer createConsumer(String name)
    {
        Consumer consumer = new Consumer(consumerRepository_.getConsumerList().size(), name);
        consumerRepository_.addConsumer(consumer);
        return consumer;
    }

    public void subscribeTopic(int consumerId,int topicId)
    {
        Topic topic = topicController_.findTopic(topicId);
        SubscribedTopic subscribedTopic = new SubscribedTopic(topic, -1);
        consumerRepository_.subscribeTopic(consumerId,subscribedTopic);
    }

    public void startConsumer(int consumerId,ConsumerEnum consumerEnum)
    {
        Consumer consumer = consumerRepository_.findConsumer(consumerId);
        ConsumerStrategy consumerStrategy = ConsumeMessageFactory.findConsumerStrategy(consumerEnum);
        consumerStrategy.consumeMessages(consumer);
    }
}
