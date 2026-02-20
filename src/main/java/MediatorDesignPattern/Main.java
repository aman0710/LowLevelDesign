package MediatorDesignPattern;

public class Main {
    public static void main(String[] args) {
        AuctionMediator auctionMediator = new Auctioneer();
        Colleague bidder1 = new Bidder("Bidder1", auctionMediator);
        Colleague bidder2 = new Bidder("Bidder2", auctionMediator);
        Colleague bidder3 = new Bidder("Bidder3", auctionMediator);

        bidder1.placeBid(100);
        bidder2.placeBid(200);
        bidder3.placeBid(300);
        bidder1.placeBid(303);
    }
}
