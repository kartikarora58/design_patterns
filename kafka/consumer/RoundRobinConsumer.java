package kafka.consumer;

import kafka.SubscribedTopic;
import kafka.message.Message;

import java.util.List;

public class RoundRobinConsumer implements ConsumerStrategy {
    @Override
    public void consumeMessages(Consumer consumer) {
        List<SubscribedTopic> subscribedTopicList = consumer.getSubscribedTopicList();

        int i = 0;
        int n = subscribedTopicList.size();
        while (i < n) {
            SubscribedTopic subscribedTopic = subscribedTopicList.get(i);
            int currentOffset = subscribedTopic.getOffset();
            int size = subscribedTopic.getTopic().getMessageList().size();
            if(currentOffset+1 == size)
                break;
            Message message = subscribedTopic.getTopic().getMessageList().get(currentOffset + 1);
            subscribedTopic.setOffset(currentOffset + 1);
            System.out.println("Consumer->" + consumer.getConsumerName() + " offset->" + currentOffset
                    + " message->" + message.getDescription());
            i = (i + 1) % n;
        }

    }
}
