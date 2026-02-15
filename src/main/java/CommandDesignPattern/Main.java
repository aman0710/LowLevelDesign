package CommandDesignPattern;

public class Main {
    public static void main(String[] args) {
        AirConditioner ac = new AirConditioner();
        RemoteControl remoteControl = new RemoteControl(new TurnAcOnCommand(ac));
        remoteControl.pressButton();
        remoteControl.displayStatus();
        remoteControl.undo();
        remoteControl.displayStatus();
    }
}
