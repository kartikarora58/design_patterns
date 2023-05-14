package org.observer.publisher;

import org.observer.Order;
import org.observer.subscriber.OrderPlacedSubscriber;

import java.util.ArrayList;
import java.util.List;

public class Flipkart implements OrderPlacedPublisher {
    private static Flipkart flipkartPublisher;
    List<OrderPlacedSubscriber> orderPlacedSubscribers;
    public static Flipkart getPublisher()
    {
        if(flipkartPublisher == null)
            flipkartPublisher = new Flipkart();
        return flipkartPublisher;
    }
    private Flipkart()
    {
        orderPlacedSubscribers = new ArrayList<>();
    }

    @Override
    public void registerSubscriber(OrderPlacedSubscriber subscriber) {
        this.orderPlacedSubscribers.add(subscriber);

    }
    @Override
    public void removeSubscriber(OrderPlacedSubscriber subscriber) {
        this.orderPlacedSubscribers.remove(subscriber);
    }
    @Override
    public void notifySubscribers(Order order) {
        for(OrderPlacedSubscriber subscriber:orderPlacedSubscribers)
        {
            subscriber.sendNotification(order);
        }
    }
   public void orderPlaced()
   {
       this.notifySubscribers(new Order());
   }
}
