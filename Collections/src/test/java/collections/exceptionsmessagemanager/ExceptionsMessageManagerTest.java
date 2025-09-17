package collections.exceptionsmessagemanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionsMessageManagerTest {
    private ExceptionsMessageManager emm;

    @BeforeEach
    void setUp(){
        Map<String, String> messageMap = new LinkedHashMap<>();
        messageMap.put("Card", "Invalid debit card number");
        messageMap.put("PIN", "Wrong PIN");
        messageMap.put("Zip code", "Invalid zip code");

        emm = new ExceptionsMessageManager(messageMap);
    }

    @Test
    void testAddExceptionMessageThrowsWhenNoSuchMessagePresent(){
        Exception ex = assertThrows(NoSuchElementException.class, () -> emm.addExceptionMessage("ow vojr vr"));
        assertEquals("No such message present.", ex.getMessage());
    }

    @Test
    void testAddExceptionMessageCorrectConcatenatingFirstTime() throws NoSuchFieldException, IllegalAccessException {
        emm.addExceptionMessage("Invalid debit card number");

        Field field = emm.getClass().getDeclaredField("generatedMessage");
        field.setAccessible(true);

        assertEquals("Invalid debit card number", field.get(emm));
    }

    @Test
    void testAddExceptionMessageCorrectConcatenatingSecondTime() throws NoSuchFieldException, IllegalAccessException {
        emm.addExceptionMessage("Invalid debit card number");
        emm.addExceptionMessage("Wrong PIN");

        Field field = emm.getClass().getDeclaredField("generatedMessage");
        field.setAccessible(true);

        assertEquals("Invalid debit card number | Wrong PIN", field.get(emm));
    }

    @Test
    void testAddExceptionMessageThrowsWhenNoSuchCodePresent(){
        Exception ex = assertThrows(NoSuchElementException.class, () -> emm.addExceptionMessageUsingCode("ow vojr vr"));
        assertEquals("No such key present.", ex.getMessage());
    }

    @Test
    void testAddExceptionMessageUsingCodeCorrectConcatenatingFirstTime() throws NoSuchFieldException, IllegalAccessException {
        emm.addExceptionMessageUsingCode("Card");

        Field field = emm.getClass().getDeclaredField("generatedMessage");
        field.setAccessible(true);

        assertEquals("Invalid debit card number", field.get(emm));
    }

    @Test
    void testAddExceptionMessageUsingCodeCorrectConcatenatingSecondTime() throws NoSuchFieldException, IllegalAccessException {
        emm.addExceptionMessageUsingCode("Card");
        emm.addExceptionMessageUsingCode("PIN");

        Field field = emm.getClass().getDeclaredField("generatedMessage");
        field.setAccessible(true);

        assertEquals("Invalid debit card number | Wrong PIN", field.get(emm));
    }

    @Test
    void testGetMessagesCorrectOperating(){
        emm.addExceptionMessageUsingCode("Card");
        emm.addExceptionMessageUsingCode("PIN");
        emm.addExceptionMessageUsingCode("Zip code");

        Collection<String> messages = ExceptionsMessageManager.getMessages(emm.getMessage());

        assertEquals("Invalid debit card number, Wrong PIN, Invalid zip code", String.join(", ", messages));
    }
}
