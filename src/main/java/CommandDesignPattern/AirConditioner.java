package CommandDesignPattern;

public class AirConditioner {
    int temp;
    boolean isOn;

    public int getTemp() {
        return this.temp;
    }

    public boolean getIsOn() {
        return this.isOn;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public void turnOnAc() {
        this.isOn = true;
    }

    public void turnOffAc() {
        this.isOn = false;
    }
}
