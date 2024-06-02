package kafka;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerController;
import kafka.consumer.ConsumerEnum;
import kafka.consumer.ConsumerRepository;
import kafka.publisher.Publisher;
import kafka.publisher.PublisherContoller;
import kafka.publisher.PublisherRepository;
import kafka.topic.Topic;
import kafka.topic.TopicController;
import kafka.topic.TopicRepository;

public class Client {
    public static void main(String[] args) {

        PublisherRepository publisherRepository = new PublisherRepository();
        ConsumerRepository consumerRepository = new ConsumerRepository();
        TopicRepository topicRepository = new TopicRepository();

        TopicController topicController = new TopicController(topicRepository);
        ConsumerController consumerController = new ConsumerController(consumerRepository,topicController);
        PublisherContoller publisherContoller = new PublisherContoller(publisherRepository,topicController);
        KafkaController kafkaController = new KafkaController(consumerController,topicController,publisherContoller);


        // create publisher
        Publisher flipkartPublisher = kafkaController.createPublisher("flipkart");

        // create topic
        Topic placeOrder = kafkaController.createTopic("placeOrder");

        // assign topic to publisher
        kafkaController.assignTopicToPublisher(flipkartPublisher.getId(), placeOrder.getId());


        // create consumers
        Consumer seller = kafkaController.createConsumer("seller");
        Consumer logistics = kafkaController.createConsumer("logistics");
        Consumer customer = kafkaController.createConsumer("customer");

        // similar to api call
        kafkaController.subscribeTopic(seller.getId(), placeOrder.getId());
        kafkaController.subscribeTopic(logistics.getId(), placeOrder.getId());
        kafkaController.subscribeTopic(customer.getId(), placeOrder.getId());



        // publish message
        kafkaController.publishMessage(flipkartPublisher.getId(), "Hey!! there is a new order");



        // start the consumer
        kafkaController.startConsumer(seller.getId(), ConsumerEnum.ROUND_ROBIN);
        kafkaController.startConsumer(logistics.getId(), ConsumerEnum.ROUND_ROBIN);
        kafkaController.startConsumer(customer.getId(), ConsumerEnum.ROUND_ROBIN);



    }
}
