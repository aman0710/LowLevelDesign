package NullObjectDesignPattern;

public class NullVehicle implements Vehicle{

    @Override
    public int seatingCapacity() {
        return 0;
    }

    @Override
    public int tankCapacity() {
        return 0;
    }
}
