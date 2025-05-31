package Logger;

public class DebugLogProcessor extends LoggerProcessor{

    DebugLogProcessor(LoggerProcessor loggerProcessor){
        super(loggerProcessor);
    }

    public void log(int logLevel, String message) {
        if(logLevel == DEBUG)
            System.out.println("DEBUG: " + message);
        else
            super.log(logLevel, message);
    }
}
