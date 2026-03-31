package kafka_multi;


import kafka_multi.service.BrokerService;import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BrokerService service = new BrokerService();
        int orderPlacedId = service.addTopic("Order Placed Topic");
        int dsId = service.addTopic("Data Science");
        int orderPlacedPublisher = service.addPublisher("Order Placed Publisher");
        service.assignTopicsToPublishers(orderPlacedPublisher, List.of(orderPlacedId));
        service.createConsumer("user", orderPlacedId);
        service.createConsumer("logistics", orderPlacedId);
        service.publishMessage(orderPlacedPublisher, "Hey! a new order is getting placed !!!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        service.publishMessage(orderPlacedPublisher, "Hey! ek aur order");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        service.createConsumer("seller", orderPlacedId);
        service.assignTopicsToPublishers(orderPlacedPublisher, List.of(dsId));
        service.publishMessage(orderPlacedPublisher, "ds team a message for you");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        service.createConsumer("ds team consumer", dsId);

    }
}
