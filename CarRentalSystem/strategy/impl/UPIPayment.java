package CarRentalSystem.strategy.impl;

import CarRentalSystem.strategy.PaymentStrategy;

public class UPIPayment implements PaymentStrategy {
    @Override
    public boolean doPayment(int amount) {
        System.out.println("UPI payment successful");
        return true;
    }
}
