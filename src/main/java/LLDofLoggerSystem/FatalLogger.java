package LLDofLoggerSystem;

public class FatalLogger extends AbstractLogger{

    public FatalLogger(int level, AbstractLogger nextLogger) {
        this.level = level;
        this.nextLogger = nextLogger;
    }

    @Override
    public void write(String message) {
        System.out.println("FATAL: " + message);
    }
}
