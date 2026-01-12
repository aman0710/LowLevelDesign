package LLDofTrafficLights;

public class YellowLightState implements TrafficLightState{
    @Override
    public void action(TrafficLight light) {
        System.out.println("The traffic light is currently Yellow, all vehicles please slow down!");
        System.out.println("Changing the traffic light to unknown!");
        light.setState(new RedLightState());
    }
}
