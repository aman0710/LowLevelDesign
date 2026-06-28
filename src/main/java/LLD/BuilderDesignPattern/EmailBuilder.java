package LLD.BuilderDesignPattern;

import java.util.List;

public class EmailBuilder {
    private String to;
    private String body;
    private String subject;
    private String cc;
    private String bcc;
    private List<String> attachments;

    public String getTo() {
        return to;
    }

    public String getBody() {
        return body;
    }

    public String getSubject() {
        return subject;
    }

    public String getCc() {
        return cc;
    }

    public String getBcc() {
        return bcc;
    }

    public List<String> getAttachments() {
        return attachments;
    }

    public EmailBuilder setTo(String to) {
        this.to = to;
        return this;
    }

    public EmailBuilder setBody(String body) {
        this.body = body;
        return this;
    }

    public EmailBuilder setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public EmailBuilder setCc(String cc) {
        this.cc = cc;
        return this;
    }

    public EmailBuilder setBcc(String bcc) {
        this.bcc = bcc;
        return this;
    }

    public EmailBuilder setAttachments(List<String> attachments) {
        this.attachments = attachments;
        return this;
    }

    public Email build() {
        return new Email(this);
    }
}
