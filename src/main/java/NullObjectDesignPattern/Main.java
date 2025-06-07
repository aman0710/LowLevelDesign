package NullObjectDesignPattern;

public class Main {
    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new VehicleFactory();
        Vehicle vehicle = vehicleFactory.getVehicleByName("Bike");
        System.out.println("Tank capacity is : " + vehicle.tankCapacity());
        System.out.println("Seating capacity is : " + vehicle.seatingCapacity());
    }
}
