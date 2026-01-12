package LLDofTrafficLights;

public class TrafficLight {
    TrafficLightState state;

    public TrafficLight() {
        this.state = new RedLightState();
    }

    public void setState(TrafficLightState state) {
        this.state = state;
    }

    public void change() {
        this.state.action(this);
    }
}
