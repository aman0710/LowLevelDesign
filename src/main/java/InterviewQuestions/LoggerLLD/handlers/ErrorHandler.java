package InterviewQuestions.LoggerLLD.handlers;

import InterviewQuestions.LoggerLLD.enums.LogLevel;

public class ErrorHandler extends LogHandler{
    @Override
    public boolean canHandle(LogLevel level) {
        return LogLevel.ERROR == level;
    }
}
