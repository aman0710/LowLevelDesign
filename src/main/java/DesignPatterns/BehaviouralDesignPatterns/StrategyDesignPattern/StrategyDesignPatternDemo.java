package DesignPatterns.BehaviouralDesignPatterns.StrategyDesignPattern;

public class StrategyDesignPatternDemo {
    public static void main(String[] args) {
        Vehicle vehicle = new SportsVehicle(new SportsDrive());
        vehicle.drive();

        vehicle = new PassengerVehicle(new NormalDrive());
        vehicle.drive();
    }
}
