package CommandDesignPattern;

import java.util.Stack;

public class RemoteControl {
    ICommand command;
    Stack<ICommand> commandHistory;

    public RemoteControl(ICommand command) {
        this.command = command;
        this.commandHistory = new Stack<>();
    }

    public void pressButton() {
        command.execute();
        commandHistory.add(command);
    }

    public void undo() {
        if(!commandHistory.isEmpty()) {
            ICommand lastCommand = commandHistory.pop();
            lastCommand.undo();
        }
    }

    public void displayStatus() {
        System.out.println("Air Conditioner is currently: " + (command.getStatus() ? "ON" : "OFF"));
    }
}
