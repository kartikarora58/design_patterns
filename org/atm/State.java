package org.atm;

public interface State {

    public void insertCard(int cardNumber, int pin);

    public void cancel();

    public void checkBalance();

    public void pressWithdrawCashButton();

    public void withDrawCash(int amount);
}
