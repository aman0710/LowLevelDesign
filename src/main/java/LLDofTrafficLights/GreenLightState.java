package LLDofTrafficLights;

public class GreenLightState implements TrafficLightState{
    @Override
    public void action(TrafficLight light) {
        System.out.println("The traffic light is currently Green, all vehicles please proceed!");
        System.out.println("Changing the traffic light to yellow!");
        light.setState(new YellowLightState());
    }
}
