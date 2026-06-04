package InterviewQuestions.LoggerLLD.model;

import InterviewQuestions.LoggerLLD.enums.LogLevel;

public class LogMessage {
    private LogLevel level;
    private String message;
    private long timestamp;

    public LogMessage(LogLevel level, String message, long timestamp) {
        this.level = level;
        this.message = message;
        this.timestamp = timestamp;
    }

    public LogLevel getLevel() {
        return level;
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
