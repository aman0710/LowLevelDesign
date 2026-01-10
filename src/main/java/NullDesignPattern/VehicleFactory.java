package NullDesignPattern;

public class VehicleFactory {
    public static Vehicle getVehicle(String vehicleName) {
        if(vehicleName.equalsIgnoreCase("car")) {
            return new Car("Black", 5);
        }
        else if(vehicleName.equalsIgnoreCase("bike")) {
            return new Bike("Red", 2);
        }
        else {
            return new NullVehicle();
        }
    }
}
