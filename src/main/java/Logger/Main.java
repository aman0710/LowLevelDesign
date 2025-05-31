package Logger;

public class Main {
    public static void main(String[] args) {
        LoggerProcessor logger = new InfoLogProcessor(new ErrorLogProcessor(new DebugLogProcessor(null)));

        logger.log(LoggerProcessor.INFO, "just an info");
        logger.log(LoggerProcessor.DEBUG, "we need to debug this");
        logger.log(LoggerProcessor.ERROR, "exception caught");
    }
}
