package kafka.consumer;

import kafka.SubscribedTopic;

import java.util.ArrayList;
import java.util.List;

public class ConsumerRepository {

    List<Consumer> consumerList_;

    public ConsumerRepository()
    {
        this.consumerList_ = new ArrayList<>();
    }

    public void addConsumer(Consumer consumer)
    {
        this.consumerList_.add(consumer);
    }

    public void subscribeTopic(int consumerId, SubscribedTopic subscribedTopic)
    {
        for(Consumer consumer: consumerList_)
        {
            if(consumer.getId() == consumerId)
            {
                consumer.getSubscribedTopicList().add(subscribedTopic);
                break;
            }
        }
    }

    public Consumer findConsumer(int consumerId)
    {
        for(Consumer consumer:consumerList_)
        {
            if(consumer.getId() == consumerId)
                return consumer;
        }
        return null;
    }
    public List<Consumer> getConsumerList() {
        return consumerList_;
    }

    public void setConsumerList(List<Consumer> consumerList) {
        consumerList_ = consumerList;
    }
}
