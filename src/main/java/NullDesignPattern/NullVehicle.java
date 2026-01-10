package NullDesignPattern;

public class NullVehicle implements Vehicle {

    private String color;
    private int seatingCapacity;

    public NullVehicle() {
        this.color = "";
        this.seatingCapacity = 0;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    public String getColor() {
        return this.color;
    }

    public int getSeatingCapacity() {
        return this.seatingCapacity;
    }

    public void setColor(String color) {

    }

    public void setSeatingCapacity(int seatingCapacity) {

    }
}
