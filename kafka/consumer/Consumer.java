package kafka.consumer;

import kafka.SubscribedTopic;

import java.util.ArrayList;
import java.util.List;

public class Consumer {
    int id;
    String consumerName;
    List<SubscribedTopic> subscribedTopicList_;

    Consumer(int id,String consumerName)
    {
        this.id = id;
        this.consumerName = consumerName;
        this.subscribedTopicList_ = new ArrayList<>();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public List<SubscribedTopic> getSubscribedTopicList() {
        return subscribedTopicList_;
    }

    public void setSubscribedTopicList(List<SubscribedTopic> subscribedTopicList) {
        subscribedTopicList_ = subscribedTopicList;
    }

}
