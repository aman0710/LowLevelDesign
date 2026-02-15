package CommandDesignPattern;

public class TurnAcOnCommand implements ICommand{

    AirConditioner airConditioner;

    public TurnAcOnCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.turnOnAc();
    }

    @Override
    public void undo() {
        airConditioner.turnOffAc();
    }

    @Override
    public boolean getStatus() {
        return airConditioner.getIsOn();
    }
}
