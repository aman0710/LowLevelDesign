package InterviewQuestions.LoggerLLD.appenders;

import InterviewQuestions.LoggerLLD.formatters.LogFormatter;
import InterviewQuestions.LoggerLLD.model.LogMessage;

public class ConsoleAppender implements LogAppender{

    private final LogFormatter formatter;

    public ConsoleAppender(LogFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public synchronized void append(LogMessage message) {
        System.out.println(formatter.format(message));
    }
}
