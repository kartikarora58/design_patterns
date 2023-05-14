package org.observer.subscriber;

import org.observer.Order;

public class CourierPartnerNotifier implements OrderPlacedSubscriber{
    @Override
    public void sendNotification(Order order) {
        System.out.println("Courier partner there a new order which needs to be delivered");
        // send request to specific courier partner containing the details of the order such as
        // pick up address and delivery address
    }
}
