package org.onlineAutionSystemMediatorDesignPattern;

public interface Colleague {
    public void placeBid(int amount);
    public void receiveBidNotification(int amount);
    public int getId();

}
