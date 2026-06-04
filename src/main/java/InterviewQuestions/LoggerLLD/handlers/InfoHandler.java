package InterviewQuestions.LoggerLLD.handlers;

import InterviewQuestions.LoggerLLD.enums.LogLevel;

public class InfoHandler extends LogHandler{
    @Override
    public boolean canHandle(LogLevel level) {
        return LogLevel.INFO == level;
    }
}
