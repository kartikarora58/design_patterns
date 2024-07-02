package org.onlineAutionSystemMediatorDesignPattern;

public class Bidder implements Colleague {

    int id;
    String name;
    Mediator mediator_;

    Bidder(int id, String name, Mediator mediator) {
        this.id = id;
        this.name = name;
        this.mediator_ = mediator;
    }

    @Override
    public void placeBid(int amount) {
        mediator_.placeBid(this, amount);
    }

    @Override
    public void receiveBidNotification(int amount) {
        System.out.println("Hi " + this.name + " There is a bid of amount- " + amount + " placed by bidder");

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
