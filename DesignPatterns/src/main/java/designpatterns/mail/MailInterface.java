package designpatterns.mail;

import java.util.List;

/**
 * Interface with the needed methods for building the mail
 */
public interface MailInterface {
    public MailFluent fillFromField(String from);

    public MailFluent fillToField(String to);

    public MailFluent fillSubjectField(String subject);

    public MailFluent fillContentField(String content);

    public MailFluent fillCCField(String cc);

    public MailFluent withAttachments(List<String> attachments);

    public MailFluent withoutAttachments();

    public Mail build();
}
