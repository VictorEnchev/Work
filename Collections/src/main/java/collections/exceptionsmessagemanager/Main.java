package collections.exceptionsmessagemanager;

import collections.hashdice.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Map<String, String> messageMap = new LinkedHashMap<>();
        messageMap.put("Card", "Invalid debit card number");
        messageMap.put("PIN", "Wrong PIN");
        messageMap.put("Zip code", "Invalid zip code");

        ExceptionsMessageManager emm = new ExceptionsMessageManager(messageMap);

        //Case 1
        emm.addExceptionMessage("Invalid debit card number");
        emm.addExceptionMessage("Wrong PIN");
        emm.addExceptionMessage("Invalid zip code");

        //Case 2
        emm.addExceptionMessageUsingCode("Card");
        emm.addExceptionMessageUsingCode("PIN");
        emm.addExceptionMessageUsingCode("Zip code");

        //Case 3
        try {
            emm.addExceptionMessage("kebvier");
        } catch (NoSuchElementException ex) {
            LOG.info(ex.getMessage());
        }

        //Case4
        try {
            emm.addExceptionMessageUsingCode("kebvier");
        } catch (NoSuchElementException ex) {
            LOG.info(ex.getMessage());
        }

        //Case 5
        LOG.info(emm.getMessage());

        //Case 6
        LOG.info(String.join(", ", ExceptionsMessageManager.getMessages(emm.getMessage())));
    }
}
