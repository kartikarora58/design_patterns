package org.observer;

import org.observer.publisher.Flipkart;
import org.observer.publisher.OrderPlacedPublisher;
import org.observer.subscriber.CourierPartnerNotifier;
import org.observer.subscriber.CustomerNotifier;
import org.observer.subscriber.OrderPlacedSubscriber;
import org.observer.subscriber.SellerNotifier;

public class Client {
    public static void main(String[] args) {
        OrderPlacedSubscriber customerNotifier = new CustomerNotifier();
        OrderPlacedSubscriber sellerNotifier = new SellerNotifier();
        OrderPlacedSubscriber courierPartnerNotifier = new CourierPartnerNotifier();

        Flipkart flipkart = Flipkart.getPublisher();
        flipkart.registerSubscriber(customerNotifier);
        flipkart.registerSubscriber(sellerNotifier);
        flipkart.registerSubscriber(courierPartnerNotifier);

        flipkart.orderPlaced();
    }
}
