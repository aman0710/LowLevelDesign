package NullDesignPattern;

public class Bike implements Vehicle{

    private String color;
    private int seatingCapacity;

    public Bike(String color, int seatingCapacity) {
        this.color = color;
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public void start() {
        System.out.println("Starting the bike!");
    }

    @Override
    public void stop() {
        System.out.println("Stopping the bike!");
    }

    public String getColor() {
        return this.color;
    }

    public int getSeatingCapacity() {
        return this.seatingCapacity;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }
}
