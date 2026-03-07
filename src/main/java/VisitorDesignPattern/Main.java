package VisitorDesignPattern;

public class Main {
    public static void main(String[] args) {
        RoomElement singleRoom = new SingleRoom();
        RoomElement doubleRoom = new DoubleRoom();
        RoomElement deluxeRoom = new DeluxeRoom();

        RoomVisitor pricingVisitor = new RoomPricingVisitor();
        RoomVisitor maintenanceVisitor = new RoomMaintenanceVisitor();

        System.out.println("Quoting the price of all suites: \n");
        singleRoom.accept(pricingVisitor);
        System.out.println("Price of single room: " + ((SingleRoom)singleRoom).roomPrice);

        doubleRoom.accept(pricingVisitor);
        System.out.println("Price of double room: " + ((DoubleRoom)doubleRoom).roomPrice);

        deluxeRoom.accept(pricingVisitor);
        System.out.println("Price of deluxe room: " + ((DeluxeRoom)deluxeRoom).roomPrice);

        System.out.println("\n");
        singleRoom.accept(maintenanceVisitor);
        doubleRoom.accept(maintenanceVisitor);
        deluxeRoom.accept(maintenanceVisitor);
    }
}
