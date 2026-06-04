package InterviewQuestions.LoggerLLD.appenders;

import InterviewQuestions.LoggerLLD.model.LogMessage;

public interface LogAppender {
    void append(LogMessage message);
}
