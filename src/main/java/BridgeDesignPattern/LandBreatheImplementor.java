package BridgeDesignPattern;

public class LandBreatheImplementor implements BreatheImplementor {

    @Override
    public void breathe() {
        System.out.println("Land breathing implementation");
    }
}
