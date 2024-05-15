package org.atm;

public class Card {
    int cardNumber;
    int pin;

    public User getUser() {
        return user_;
    }

    public void setUser(User user) {
        user_ = user;
    }

    User user_;
    Card(int cardNumber, int pin)
    {
        this.cardNumber = cardNumber;
        this.pin = pin;
    }
    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
