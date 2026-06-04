package InterviewQuestions.LoggerLLD.handlers;

import InterviewQuestions.LoggerLLD.enums.LogLevel;

public class WarnHandler extends LogHandler{
    @Override
    public boolean canHandle(LogLevel level) {
        return LogLevel.WARN == level;
    }
}
