package VisitorDesignPattern;

public class RoomPricingVisitor implements RoomVisitor {
    @Override
    public void visit(SingleRoom singleRoom) {
        singleRoom.roomPrice = 1000;
        System.out.println("Setting the price for single room");
    }

    @Override
    public void visit(DoubleRoom doubleRoom) {
        doubleRoom.roomPrice = 2000;
        System.out.println("Setting the price for double room");
    }

    @Override
    public void visit(DeluxeRoom deluxeRoom) {
        deluxeRoom.roomPrice = 3000;
        System.out.println("Setting the price for deluxe room");
    }
}
