package org.onlineAutionSystemMediatorDesignPattern;
import java.util.ArrayList;
import java.util.List;
public class Auctioneer implements Mediator{

    List<Colleague> colleagueList_;

    Auctioneer()
    {
        colleagueList_ = new ArrayList<>();
    }


    @Override
    public void placeBid(Colleague colleague, int amount) {
        for(Colleague bidder:colleagueList_)
        {
            if(bidder.getId()!=colleague.getId())
                bidder.receiveBidNotification(amount);
        }
    }

    @Override
    public void addBidder(Colleague bidder) {
        colleagueList_.add(bidder);
    }
}
