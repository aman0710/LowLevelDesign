package BridgeDesignPattern;

public abstract class LivingThing {
    BreatheImplementor breatheImplementor;

    public LivingThing(BreatheImplementor breatheImplementor) {
        this.breatheImplementor = breatheImplementor;
    }
    abstract public void breatheProcess();
}
