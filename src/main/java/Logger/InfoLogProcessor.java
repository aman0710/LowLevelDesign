package Logger;

public class InfoLogProcessor extends LoggerProcessor{
    InfoLogProcessor(LoggerProcessor loggerProcessor){
        super(loggerProcessor);
    }

    public void log(int logLevel, String message) {
        if(logLevel == INFO)
            System.out.println("INFO: " + message);
        else
            super.log(logLevel, message);
    }
}
