package DesignPatterns.BehaviouralDesignPatterns.StrategyDesignPattern;

public class Vehicle {
    Drive drive;
    public Vehicle(Drive drive) {
        this.drive = drive;
    }

    public void drive() {
        System.out.println(this.getClass().getSimpleName());
        drive.drive();
    }
}
