package NullObjectDesignPattern;

public class Car implements Vehicle{
    @Override
    public int seatingCapacity() {
        return 5;
    }

    @Override
    public int tankCapacity() {
        return 40;
    }
}
