package MediatorDesignPattern;

public interface AuctionMediator {
    void placeBid(Colleague bidder, int bidAmount);
    void addBidder(Colleague bidder);
}
