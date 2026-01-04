package LLDofLoggerSystem;

public abstract class AbstractLogger {

    public static final int DEBUG = 1;
    public static final int INFO = 2;
    public static final int ERROR = 3;
    public static final int FATAL = 4;
    int level;
    AbstractLogger nextLogger;

    public void logMessage(int level, String message) {
        if(this.level == level) {
            write(message);
        }
        if(this.nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    public abstract void write(String message);
}
