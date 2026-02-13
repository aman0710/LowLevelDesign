package FlyWeightDesignPatttern.RoboticGameDesign;

public class HumanoidRobot implements IRobot{

    private final String type;
    private final Sprites body;

    HumanoidRobot(String type, Sprites body) {
        this.type = type;
        this.body = body;
    }

    public String getType() {
        return this.type;
    }

    public Sprites getBody() {
        return this.body;
    }

    @Override
    public void display(int x, int y) {
        System.out.println("Displaying " + type + " at " + x + ", " + y);
    }
}
