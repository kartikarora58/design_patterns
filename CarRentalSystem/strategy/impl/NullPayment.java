package CarRentalSystem.strategy.impl;

import CarRentalSystem.strategy.PaymentStrategy;

public class NullPayment implements PaymentStrategy {
    @Override
    public boolean doPayment(int amount) {
        System.out.println("Payment method not present");
        return false;
    }
}
