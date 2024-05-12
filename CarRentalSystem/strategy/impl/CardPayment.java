package CarRentalSystem.strategy.impl;

import CarRentalSystem.strategy.PaymentStrategy;

public class CardPayment implements PaymentStrategy {
    @Override
    public boolean doPayment(int amount) {
        System.out.println("CARD payment successful");
        return true;
    }
}
