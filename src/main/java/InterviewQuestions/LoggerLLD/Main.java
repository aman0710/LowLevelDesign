package InterviewQuestions.LoggerLLD;

import InterviewQuestions.LoggerLLD.appenders.ConsoleAppender;
import InterviewQuestions.LoggerLLD.appenders.FileAppender;
import InterviewQuestions.LoggerLLD.enums.LogLevel;
import InterviewQuestions.LoggerLLD.formatters.JsonFormatter;
import InterviewQuestions.LoggerLLD.formatters.PlainTextFormatter;

public class Main {
    public static void main(String[] args) {
        LogHandlerConfig.addAppenderForLevel(LogLevel.INFO, new ConsoleAppender(new PlainTextFormatter()));
        LogHandlerConfig.addAppenderForLevel(LogLevel.INFO, new FileAppender(new JsonFormatter(), "info_logs.txt"));
        LogHandlerConfig.addAppenderForLevel(LogLevel.ERROR, new ConsoleAppender(new JsonFormatter()));
        LogHandlerConfig.addAppenderForLevel(LogLevel.ERROR, new FileAppender(new PlainTextFormatter(), "error_logs.txt"));

        Logger logger = Logger.getInstance();
        logger.info("Data successfully fetched from API");
        logger.error("No response from API with the correlation id: abcd");
    }
}
