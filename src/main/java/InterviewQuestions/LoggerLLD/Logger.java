package InterviewQuestions.LoggerLLD;

import InterviewQuestions.LoggerLLD.enums.LogLevel;
import InterviewQuestions.LoggerLLD.handlers.LogHandler;
import InterviewQuestions.LoggerLLD.model.LogMessage;

public class Logger {
    private static final Logger INSTANCE = new Logger();
    private final LogHandler handlerChain;
    private Logger() {
        this.handlerChain = LogHandlerConfig.build();
    }
    public static Logger getInstance() {
        return INSTANCE;
    }

    private void log(LogLevel level, String message) {
        LogMessage newMessage = new LogMessage(level, message, System.currentTimeMillis());
        handlerChain.handle(newMessage);
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void warn(String message) {
        log(LogLevel.WARN, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public void fatal(String message) {
        log(LogLevel.FATAL, message);
    }
}
