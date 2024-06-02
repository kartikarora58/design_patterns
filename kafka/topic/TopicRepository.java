package kafka.topic;

import java.util.ArrayList;
import java.util.List;

public class TopicRepository {
    List<Topic> topicList_;

    public TopicRepository()
    {
        topicList_ = new ArrayList<>();
    }

    public void save(Topic topic)
    {
        this.topicList_.add(topic);

    }

    public List<Topic> getTopicList() {
        return topicList_;
    }
    public void setTopicList(List<Topic> topicList) {
        topicList_ = topicList;
    }

    public void deleteTopic(int id)
    {

    }

    public Topic findTopicById(int topicId)
    {
        for(Topic topic:topicList_)
        {
            if(topic.getId() == topicId)
                return topic;
        }
        return null;
    }

}
