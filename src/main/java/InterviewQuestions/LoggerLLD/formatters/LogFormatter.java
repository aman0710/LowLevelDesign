package InterviewQuestions.LoggerLLD.formatters;

import InterviewQuestions.LoggerLLD.model.LogMessage;

public interface LogFormatter {
    String format(LogMessage message);
}
