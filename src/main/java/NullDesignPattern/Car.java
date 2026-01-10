package NullDesignPattern;

public class Car implements Vehicle{

    private String color;
    private int seatingCapacity;

    public Car(String color, int seatingCapacity) {
        this.color = color;
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public void start() {
        System.out.println("Starting the car!");
    }

    @Override
    public void stop() {
        System.out.println("Stopping the car!");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }
}
