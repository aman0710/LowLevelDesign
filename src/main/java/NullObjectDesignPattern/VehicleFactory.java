package NullObjectDesignPattern;

public class VehicleFactory {
     Vehicle getVehicleByName(String vehicleName) {
        if(vehicleName.equalsIgnoreCase("CAR"))
            return new Car();
        return new NullVehicle();
    }
}
