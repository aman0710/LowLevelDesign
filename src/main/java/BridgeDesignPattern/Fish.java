package BridgeDesignPattern;

public class Fish extends LivingThing{
    public Fish(BreatheImplementor breatheImplementor) {
        super(breatheImplementor);
    }

    @Override
    public void breatheProcess() {
        breatheImplementor.breathe();
    }
}
