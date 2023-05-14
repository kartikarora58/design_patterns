package org.observer.subscriber;

import org.observer.Order;

public interface OrderPlacedSubscriber {
    public void sendNotification(Order order);
}
