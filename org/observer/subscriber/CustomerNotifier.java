package org.observer.subscriber;

import org.observer.Order;

public class CustomerNotifier implements OrderPlacedSubscriber {
    @Override
    public void sendNotification(Order order) {
        System.out.println("Dear customer your order has been placed successfully");
        // send notification to customer for successful placement  of order and details of the order
    }
}
