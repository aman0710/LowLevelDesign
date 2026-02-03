package BridgeDesignPattern;

public class WaterBreatheImplementor implements BreatheImplementor {
    @Override
    public void breathe() {
        System.out.println("Water breathing implementation");
    }
}
