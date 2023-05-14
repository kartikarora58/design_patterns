package org.observer.subscriber;

import org.observer.Order;

public class SellerNotifier implements OrderPlacedSubscriber{
    @Override
    public void sendNotification(Order order) {
        // send notification to seller
        System.out.println("sending notification to seller");

    }
}
