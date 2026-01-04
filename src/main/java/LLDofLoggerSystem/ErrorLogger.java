package LLDofLoggerSystem;

public class ErrorLogger extends AbstractLogger{

    public ErrorLogger(int level, AbstractLogger nextLogger) {
        this.level = level;
        this.nextLogger = nextLogger;
    }

    @Override
    public void write(String message) {
        System.out.println("ERROR: " + message);
    }
}
