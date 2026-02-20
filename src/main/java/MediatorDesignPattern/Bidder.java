package MediatorDesignPattern;

public class Bidder implements Colleague {
    String name;
    AuctionMediator auctionMediator;

    public Bidder(String name, AuctionMediator auctionMediator) {
        this.name = name;
        this.auctionMediator = auctionMediator;
        this.auctionMediator.addBidder(this);
    }

    @Override
    public void placeBid(int bidAmount) {
        this.auctionMediator.placeBid(this, bidAmount);
    }

    @Override
    public void receiveBidNotification(int bidAmount) {
        System.out.println(name + " received a bid notification for amount: " + bidAmount);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
