package Logger;

public class ErrorLogProcessor extends LoggerProcessor{

    ErrorLogProcessor(LoggerProcessor loggerProcessor){
        super(loggerProcessor);
    }

    public void log(int logLevel, String message) {
        if(logLevel == ERROR)
            System.out.println("ERROR: " + message);
        else
            super.log(logLevel, message);
    }
}
