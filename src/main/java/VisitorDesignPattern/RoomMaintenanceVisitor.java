package VisitorDesignPattern;

public class RoomMaintenanceVisitor implements RoomVisitor {
    @Override
    public void visit(SingleRoom singleRoom) {
        System.out.println("Maintenance in progress for single room");
    }

    @Override
    public void visit(DoubleRoom doubleRoom) {
        System.out.println("Maintenance in progress for double room");
    }

    @Override
    public void visit(DeluxeRoom deluxeRoom) {
        System.out.println("Maintenance in progress for deluxe room");
    }
}
