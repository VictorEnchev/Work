package designpatterns.mail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

class MailFluentTest {
    @Test
    void testFillFromFieldCorrectFilling() throws NoSuchFieldException, IllegalAccessException {
        Mail mail = MailFluent.getInstance()
                .fillFromField("Victor")
                .build();

        Field field = mail.getClass().getDeclaredField("from");
        field.setAccessible(true);

        Assertions.assertEquals("Victor", field.get(mail));
    }

    @Test
    void testFillToFieldCorrectFilling() throws NoSuchFieldException, IllegalAccessException {
        Mail mail = MailFluent.getInstance()
                .fillToField("Victor")
                .build();

        Field field = mail.getClass().getDeclaredField("to");
        field.setAccessible(true);

        Assertions.assertEquals("Victor", field.get(mail));
    }

    @Test
    void testFillSubjectFieldCorrectFilling() throws NoSuchFieldException, IllegalAccessException {
        Mail mail = MailFluent.getInstance()
                .fillSubjectField("Victor")
                .build();

        Field field = mail.getClass().getDeclaredField("subject");
        field.setAccessible(true);

        Assertions.assertEquals("Victor", field.get(mail));
    }

    @Test
    void testFillContentFieldCorrectFilling() throws NoSuchFieldException, IllegalAccessException {
        Mail mail = MailFluent.getInstance()
                .fillContentField("Victor")
                .build();

        Field field = mail.getClass().getDeclaredField("content");
        field.setAccessible(true);

        Assertions.assertEquals("Victor", field.get(mail));
    }

    @Test
    void testFillCCFieldCorrectFilling() throws NoSuchFieldException, IllegalAccessException {
        Mail mail = MailFluent.getInstance()
                .fillCCField("Victor")
                .build();

        Field field = mail.getClass().getDeclaredField("cc");
        field.setAccessible(true);

        Assertions.assertEquals("Victor", field.get(mail));
    }

    @Test
    void testWithAttachmentsCorrectFilling() throws NoSuchFieldException, IllegalAccessException {
        Mail mail = MailFluent.getInstance()
                .withAttachments(List.of("Victor"))
                .build();

        Field field = mail.getClass().getDeclaredField("attachments");
        field.setAccessible(true);

        Assertions.assertEquals(List.of("Victor"), field.get(mail));
    }

    @Test
    void testWithoutAttachmentsCorrectFilling() throws NoSuchFieldException, IllegalAccessException {
        Mail mail = MailFluent.getInstance()
                .withoutAttachments()
                .build();

        Field field = mail.getClass().getDeclaredField("attachments");
        field.setAccessible(true);

        Assertions.assertNull(field.get(mail));
    }
}
