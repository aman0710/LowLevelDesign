package BridgeDesignPattern;

public class PlantBreatheImplementor implements BreatheImplementor {

    @Override
    public void breathe() {
        System.out.println("Plant breathing implementation");
    }
}
