package org.observer.publisher;

import org.observer.Order;
import org.observer.subscriber.OrderPlacedSubscriber;

public interface OrderPlacedPublisher {
    public void registerSubscriber(OrderPlacedSubscriber subscriber);
    public void removeSubscriber(OrderPlacedSubscriber subscriber);
    public void notifySubscribers(Order order);
}
