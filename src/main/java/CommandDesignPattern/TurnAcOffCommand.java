package CommandDesignPattern;

public class TurnAcOffCommand implements ICommand{

    AirConditioner airConditioner;

    public TurnAcOffCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.turnOffAc();
    }

    @Override
    public void undo() {
        airConditioner.turnOnAc();
    }

    @Override
    public boolean getStatus() {
        return airConditioner.getIsOn();
    }
}
