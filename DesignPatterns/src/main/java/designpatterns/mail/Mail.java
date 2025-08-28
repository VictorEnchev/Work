package designpatterns.mail;

import java.util.List;

/**
 * Class representing a mail
 */
public class Mail {
    private String from;
    private String to;
    private String subject;
    private String content;
    private String cc;
    private List<String> attachments;

    public Mail(String from, String to, String subject, String content, String cc, List<String> attachments) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.content = content;
        this.cc = cc;
        this.attachments = attachments;
    }
}
