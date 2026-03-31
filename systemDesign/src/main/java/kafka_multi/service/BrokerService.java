package kafka_multi.service;

import kafka_multi.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrokerService {

    Map<Integer, Publisher> publishers;
    Map<Integer, Topic> topics;
    Map<Integer, List<Consumer>> topicMetadata;

    public BrokerService() {
        this.publishers = new HashMap<>();
        this.topics = new HashMap<>();
        this.topicMetadata = new HashMap<>();
    }

    public int addTopic(String name) {
        int idx = topics.size();
        Topic topic = new Topic(idx, name);
        topics.put(idx, topic);
        return idx;
    }

    public int addPublisher(String name) {
        int idx = publishers.size();
        Publisher publisher = new Publisher(idx, name);
        publishers.put(idx, publisher);
        return idx;
    }

    public void assignTopicsToPublishers(int id, List<Integer> topicIds) {
        Publisher publisher = publishers.get(id);
        for (int topicId : topicIds)
            publisher.topics.add(topics.get(topicId));
    }

    public void createConsumer(String name, int topicId) {
        ConsumerTopic consumerTopic = new ConsumerTopic(topics.get(topicId));
        Consumer consumer = new Consumer(name, consumerTopic);
        if (!topicMetadata.containsKey(topicId))
            topicMetadata.put(topicId, new ArrayList<>());
        topicMetadata.get(topicId).add(consumer);
        new Thread(new ConsumerController(consumer)).start();
    }

    public void publishMessage(int publisherId, String content) {
        Message message = new Message(content);
        List<Topic> topics = publishers.get(publisherId).topics;
        for (Topic topic : topics) {
            topic.messages.add(message);
            if (!topicMetadata.containsKey(topic.id))
                continue;
            for (Consumer consumer : topicMetadata.get(topic.id)) {
                synchronized (consumer) {
                    consumer.notify();
                }
            }
        }
    }
}
