package CarRentalSystem.strategy.impl;

import CarRentalSystem.strategy.PaymentStrategy;

public class NetBanking implements PaymentStrategy {
    @Override
    public boolean doPayment(int amount) {
        System.out.println("NET banking payment successful");
        return true;
    }
}
