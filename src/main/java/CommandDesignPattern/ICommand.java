package CommandDesignPattern;

public interface ICommand {
    void execute();
    void undo();
    boolean getStatus();
}
