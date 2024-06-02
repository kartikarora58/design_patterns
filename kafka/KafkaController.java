package kafka;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerController;
import kafka.consumer.ConsumerEnum;
import kafka.consumer.ConsumerStrategy;
import kafka.publisher.Publisher;
import kafka.publisher.PublisherContoller;
import kafka.topic.Topic;
import kafka.topic.TopicController;


// analogous to API endpoint
public class KafkaController {

    ConsumerController consumerController_;
    TopicController topicController_;
    PublisherContoller publisherContoller_;

    KafkaController(
            ConsumerController consumerController, TopicController topicController
            , PublisherContoller publisherContoller) {
        consumerController_ = consumerController;
        topicController_ = topicController;
        publisherContoller_ = publisherContoller;
    }

    public Publisher createPublisher(String name)
    {
        return publisherContoller_.addPublisher(name);
    }

    public Topic createTopic(String name)
    {
        return topicController_.createTopic(name);
    }
    public void assignTopicToPublisher(int publisherId,int topicId)
    {
        publisherContoller_.assignTopicToPublisher(publisherId,topicId);
    }

    public void publishMessage(int publisherId,String payload)
    {
        publisherContoller_.publishMessage(publisherId,payload);
    }

    public Consumer createConsumer(String consumerName)
    {
        return consumerController_.createConsumer(consumerName);
    }

    public void subscribeTopic(int consumerId,int topicId)
    {
        consumerController_.subscribeTopic(consumerId,topicId);
    }

    public void startConsumer(int consumerId, ConsumerEnum consumerEnum)
    {
        consumerController_.startConsumer(consumerId,consumerEnum);
    }
}
