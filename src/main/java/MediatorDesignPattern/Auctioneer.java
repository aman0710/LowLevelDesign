package MediatorDesignPattern;


import java.util.ArrayList;
import java.util.List;

public class Auctioneer implements AuctionMediator {
    List<Colleague> colleagues;

    public Auctioneer() {
        this.colleagues = new ArrayList<>();
    }

    @Override
    public void placeBid(Colleague bidder, int bidAmount) {
        for(Colleague colleague: colleagues) {
            if(!colleague.getName().equalsIgnoreCase(bidder.getName())) {
                colleague.receiveBidNotification(bidAmount);
            }
        }
    }

    @Override
    public void addBidder(Colleague bidder) {
        this.colleagues.add(bidder);
    }
}