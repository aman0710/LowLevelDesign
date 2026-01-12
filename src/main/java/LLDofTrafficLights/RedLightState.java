package LLDofTrafficLights;

public class RedLightState implements TrafficLightState{

    @Override
    public void action(TrafficLight light) {
        System.out.println("The traffic light is currently Red, all vehicles please stop!");
        System.out.println("Changing the traffic light to green!");
        light.setState(new GreenLightState());
    }
}
