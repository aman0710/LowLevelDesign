package InterviewQuestions.LoggerLLD.handlers;

import InterviewQuestions.LoggerLLD.enums.LogLevel;

public class DebugHandler extends LogHandler{
    @Override
    public boolean canHandle(LogLevel level) {
        return LogLevel.DEBUG == level;
    }
}
