package lld.kafka_multi.service;

import lld.kafka_multi.model.Consumer;
import lld.kafka_multi.model.Message;
import lld.kafka_multi.model.Topic;

import java.util.List;

public class ConsumerController implements Runnable {

    final Consumer consumer;

    public ConsumerController(Consumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void run() {
        try {
            Topic topic = consumer.consumerTopic.topic;
            List<Message> messageList = topic.messages;
            while (true) {
                synchronized (consumer) {
                    while (consumer.consumerTopic.offset >= messageList.size()) {
                        System.out.println("consumer " + consumer.name +" is in waiting state");
                        consumer.wait();
                    }
                    Message message = messageList.get(consumer.consumerTopic.offset);
                    processMessage(message);
                    consumer.consumerTopic.offset++;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void processMessage(Message message) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(message.content + " consumed by consumer " + consumer.name);
    }
}
