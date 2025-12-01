package DesignPatterns.BehaviouralDesignPatterns.StrategyDesignPattern;

public class SportsDrive implements Drive{
    @Override
    public void drive() {
        System.out.println("Drive capability: Sports");
    }
}
