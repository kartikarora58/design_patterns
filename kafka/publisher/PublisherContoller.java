package kafka.publisher;

import kafka.message.Message;
import kafka.topic.Topic;
import kafka.topic.TopicController;

public class PublisherContoller {

    PublisherRepository publisherRepository_;

    TopicController topicController_;

    public PublisherContoller(PublisherRepository publisherRepository, TopicController topicController)
    {
        publisherRepository_ = publisherRepository;
        topicController_ = topicController;
    }

    public void publishMessage(int publisherId,String payload)
    {
        // find publisher by publisher Id
        Publisher publisher = publisherRepository_.findPublisherById(publisherId);
        // create Message
        Message message=new Message(1,payload);

        for(Topic topic:publisher.getTopicList())
        {
            topic.getMessageList().add(message);
        }

    }

    public Publisher addPublisher(String name)
    {
        Publisher publisher = new Publisher(publisherRepository_.getPublisherList().size(),name);
        publisherRepository_.savePublisher(publisher);
        return publisher;
    }

    public void assignTopicToPublisher(int publisherId,int topicId)
    {
        Topic topic = topicController_.findTopic(topicId);
        publisherRepository_.assignTopic(publisherId,topic);
    }
}
