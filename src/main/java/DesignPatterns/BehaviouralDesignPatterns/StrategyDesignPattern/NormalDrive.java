package DesignPatterns.BehaviouralDesignPatterns.StrategyDesignPattern;

public class NormalDrive implements Drive{
    @Override
    public void drive() {
        System.out.println("Drive capability: Normal");
    }
}
