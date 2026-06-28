package LLD.BuilderDesignPattern;

import java.util.List;

public class Email {
    private String to;
    private String body;
    private List<String> attachments;
    private String subject;
    private String cc;
    private String bcc;

    public Email(EmailBuilder builder) {
        this.to = builder.getTo();
        this.body = builder.getBody();
        this.subject = builder.getSubject();
        this.cc = builder.getCc();
        this.bcc = builder.getBcc();
        this.attachments = builder.getAttachments();
    }

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

    public List<String> getAttachment() {
        return attachments;
    }


}
