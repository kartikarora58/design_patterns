package kafka.topic;

import kafka.message.Message;

public class TopicController {

    TopicRepository topicRepository_;

    public TopicController(TopicRepository topicRepository)
    {
        this.topicRepository_ = topicRepository;
    }

    public Topic createTopic(String name)
    {
        Topic topic = new Topic(topicRepository_.getTopicList().size(),name);
        topicRepository_.save(topic);
        return topic;
    }

    public void addMesssage(Topic topic, Message message)
    {
        topic.getMessageList().add(message);
    }

    public void deleteTopic(int id)
    {

    }

    public Topic findTopic(int topicId)
    {
        return topicRepository_.findTopicById(topicId);
    }
}
