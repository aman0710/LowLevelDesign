package InterviewQuestions.LoggerLLD.handlers;

import InterviewQuestions.LoggerLLD.appenders.LogAppender;
import InterviewQuestions.LoggerLLD.enums.LogLevel;
import InterviewQuestions.LoggerLLD.model.LogMessage;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class LogHandler {
    protected LogHandler next;
    protected List<LogAppender> appenders = new CopyOnWriteArrayList<>();

    public void setNext(LogHandler next) {
        this.next = next;
    }

    public void subscribe(LogAppender observer) {
        this.appenders.add(observer);
    }

    public void notifyObservers(LogMessage message) {
        for(LogAppender appender: appenders) {
            appender.append(message);
        }
    }

    public void handle(LogMessage message) {
        if(canHandle(message.getLevel())) {
            notifyObservers(message);
        } else if(next != null) {
            next.handle(message);
        }
    }

    public abstract boolean canHandle(LogLevel level);
}
