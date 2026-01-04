package LLDofLoggerSystem;

public class DebugLogger extends AbstractLogger{

    public DebugLogger(int level, AbstractLogger nextLogger) {
        this.level = level;
        this.nextLogger = nextLogger;
    }

    @Override
    public void write(String message) {
        System.out.println("DEBUG: " + message);
    }
}
