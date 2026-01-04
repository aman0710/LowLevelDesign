package LLDofLoggerSystem;

public class Main {
    public static void main(String[] args) {
        AbstractLogger fatalLogger = new FatalLogger(AbstractLogger.FATAL, null);
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR, fatalLogger);
        AbstractLogger infoLogger = new InfoLogger(AbstractLogger.INFO, errorLogger);
        AbstractLogger logger = new DebugLogger(AbstractLogger.DEBUG, infoLogger);

        logger.logMessage(AbstractLogger.INFO, "This is an INFO message");
        logger.logMessage(AbstractLogger.DEBUG, "This is a DEBUG message");
        logger.logMessage(AbstractLogger.ERROR, "This is an ERROR message");
        logger.logMessage(AbstractLogger.FATAL, "This is a FATAL message");
    }
}
