package FlyWeightDesignPatttern.RoboticGameDesign;

public class RoboticGame {
    public static void main(String[] args) {
        System.out.println("==============FlyWeight Design Pattern================");
        IRobot humanoidRobot1 = RobotFactory.createRobot("HUMANOID");
        IRobot humanoidRobot2 = RobotFactory.createRobot("HUMANOID");
        humanoidRobot1.display(1, 2);
        humanoidRobot2.display(10,20);
        IRobot roboticDog1 = RobotFactory.createRobot("ROBOTIC_DOG");
        IRobot roboticDog2 = RobotFactory.createRobot("ROBOTIC_DOG");
        roboticDog1.display(3, 9);
        roboticDog2.display(12, 27);

        System.out.println("Total number of robots : " + RobotFactory.getTotalRobots());
    }
}
