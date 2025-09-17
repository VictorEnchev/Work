package collections.exceptionsmessagemanager;

import java.util.*;

public class ExceptionsMessageManager {
    private static final String DELIMITER = " | ";

    private final Map<String, String> predefinedExceptions;
    private String generatedMessage;

    public ExceptionsMessageManager(Map<String, String> predefinedExceptions) {
        this.predefinedExceptions = predefinedExceptions;
        this.generatedMessage = "";
    }

    public void addExceptionMessage(String message){
        predefinedExceptions.values()
                .stream()
                .filter(m -> m.equals(message))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No such message present."));

        if(generatedMessage.isEmpty()) this.generatedMessage = message;
        else this.generatedMessage = this.generatedMessage + DELIMITER + message;
    }

    public void addExceptionMessageUsingCode(String messageCode){
        if(!predefinedExceptions.containsKey(messageCode))
            throw new NoSuchElementException("No such key present.");

        if(generatedMessage.isEmpty()) this.generatedMessage = predefinedExceptions.get(messageCode);
        else this.generatedMessage = this.generatedMessage + DELIMITER + predefinedExceptions.get(messageCode);
    }

    public String getMessage(){
        return this.generatedMessage;
    }

    public static Collection<String> getMessages(String messageCombination){
        return Arrays.stream(messageCombination.split(" \\| ")).toList();
    }
}

