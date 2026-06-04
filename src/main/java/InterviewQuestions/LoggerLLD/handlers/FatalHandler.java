package InterviewQuestions.LoggerLLD.handlers;

import InterviewQuestions.LoggerLLD.enums.LogLevel;

public class FatalHandler extends LogHandler{
    @Override
    public boolean canHandle(LogLevel level) {
        return LogLevel.FATAL == level;
    }
}
