package FlyWeightDesignPatttern.RoboticGameDesign;

import java.util.HashMap;
import java.util.Map;

public class RobotFactory {
    public static Map<String, IRobot> robotMap = new HashMap<>();
    public static IRobot createRobot(String robotType) {
        if(robotMap.containsKey(robotType)) {
            return robotMap.get(robotType);
        }
        if("HUMANOID".equalsIgnoreCase(robotType)) {
            Sprites humanoidSprite = new Sprites();
            IRobot humanoidRobot = new HumanoidRobot(robotType, humanoidSprite);
            robotMap.put(robotType, humanoidRobot);
            return humanoidRobot;
        } else if("ROBOTIC_DOG".equalsIgnoreCase(robotType)) {
            Sprites roboticDogSprite = new Sprites();
            IRobot roboticDogObject = new RoboticDog(robotType, roboticDogSprite);
            robotMap.put(robotType, roboticDogObject);
            return roboticDogObject;
        }
        throw new IllegalArgumentException("Invalid robot type: " + robotType);
    }

    public static int getTotalRobots() {
        return robotMap.size();
    }
}
