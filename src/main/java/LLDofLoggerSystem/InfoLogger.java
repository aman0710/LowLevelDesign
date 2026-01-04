package LLDofLoggerSystem;

public class InfoLogger extends AbstractLogger{

    public InfoLogger(int level, AbstractLogger nextLogger) {
        this.level = level;
        this.nextLogger = nextLogger;
    }

    @Override
    public void write(String message) {
        System.out.println("INFO: " + message);
    }
}
