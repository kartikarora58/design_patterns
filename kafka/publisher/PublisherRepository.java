package kafka.publisher;
import kafka.topic.Topic;

import java.util.ArrayList;
import java.util.List;
public class PublisherRepository {
    List<Publisher> publisherList_;

    public PublisherRepository()
    {
        publisherList_ = new ArrayList<>();
    }

    public Publisher findPublisherById(int publisherId)
    {
        for(Publisher publisher:publisherList_)
        {
            if(publisher.getId() == publisherId)
                return publisher;
        }
        return null;
    }

    public List<Publisher> getPublisherList() {
        return publisherList_;
    }

    public void setPublisherList(List<Publisher> publisherList) {
        publisherList_ = publisherList;
    }

    public void assignTopic(int publisherId, Topic topic)
    {
        for(Publisher publisher:publisherList_)
        {
            if(publisher.getId() == publisherId)
            {
                publisher.getTopicList().add(topic);
            }
        }

    }

    public void savePublisher(Publisher publisher)
    {
        publisherList_.add(publisher);
    }



}
