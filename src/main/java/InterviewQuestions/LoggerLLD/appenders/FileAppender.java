package InterviewQuestions.LoggerLLD.appenders;

import InterviewQuestions.LoggerLLD.formatters.LogFormatter;
import InterviewQuestions.LoggerLLD.model.LogMessage;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileAppender implements LogAppender{
    private final LogFormatter formatter;
    private final BufferedWriter writer;

    public FileAppender(LogFormatter formatter, String fileName) {
        this.formatter = formatter;
        try {
            this.writer = new BufferedWriter(new FileWriter(fileName, true));
        } catch (Exception e) {
            throw new RuntimeException("Failed to open log file", e);
        }
    }

    @Override
    public synchronized void append(LogMessage message) {
        try {
            writer.write(formatter.format(message));
            writer.newLine();
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void close() {
        try {
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
