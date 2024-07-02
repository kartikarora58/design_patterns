package org.onlineAutionSystemMediatorDesignPattern;

public class Client {
    public static void main(String[] args) {
        Mediator mediator= new Auctioneer();
        Colleague kartik = new Bidder(1,"Kartik",mediator);
        Colleague karan = new Bidder(2,"Karan",mediator);
        Colleague arash = new Bidder(3,"Arash",mediator);

        mediator.addBidder(kartik);
        mediator.addBidder(karan);
        mediator.addBidder(arash);

        kartik.placeBid(100);
        karan.placeBid(200);
        arash.placeBid(300);

    }
}
