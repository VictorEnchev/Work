package designpatterns.mail;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Mail mail = MailFluent.getInstance()
                .fillFromField("Viktor")
                .fillToField("Angel")
                .fillSubjectField("Porno")
                .fillContentField("Mnogo porno")
                .fillCCField("subtitri")
                .withoutAttachments()
                .build();
    }
}
