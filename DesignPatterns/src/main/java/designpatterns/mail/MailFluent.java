package designpatterns.mail;

import java.util.List;

/**
 * Class that allows building the email via method chaining
 */
public class MailFluent implements MailInterface {
    private String from;
    private String to;
    private String subject;
    private String content;
    private String cc;
    private List<String> attachments;

    private MailFluent(String from, String to, String subject, String content, String cc, List<String> attachments) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.content = content;
        this.cc = cc;
        this.attachments = attachments;
    }

    public MailFluent() {
    }

    public static MailFluent getInstance(){
        return new MailFluent();
    }

    @Override
    public MailFluent fillFromField(String from) {
        this.from = from;
        return this;
    }

    @Override
    public MailFluent fillToField(String to) {
        this.to = to;
        return this;
    }

    @Override
    public MailFluent fillSubjectField(String subject) {
        this.subject = subject;
        return this;
    }

    @Override
    public MailFluent fillContentField(String content) {
        this.content = content;
        return this;
    }

    @Override
    public MailFluent fillCCField(String cc) {
        this.cc = cc;
        return this;
    }

    @Override
    public MailFluent withAttachments(List<String> attachments) {
        this.attachments = attachments;
        return this;
    }

    @Override
    public MailFluent withoutAttachments() {
        this.attachments = null;
        return this;
    }

    @Override
    public Mail build() {
        return new Mail(from, to, subject, content, cc, attachments);
    }
}
