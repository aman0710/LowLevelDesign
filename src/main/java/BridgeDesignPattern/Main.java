package BridgeDesignPattern;

public class Main {
    public static void main(String[] args) {
        LivingThing fishObject = new Fish(new WaterBreatheImplementor());
        fishObject.breatheProcess();
    }
}
