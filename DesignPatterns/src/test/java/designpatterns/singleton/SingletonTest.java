package designpatterns.singleton;

import nl.altindag.log.LogCaptor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SingletonTest {
    @Test
    void testGetInstanceLogsMessageWhenItShould(){
        LogCaptor captor = LogCaptor.forClass(Singleton.class);
        Singleton instance = Singleton.getInstance();

        Assertions.assertEquals("Singleton created!", captor.getInfoLogs().getFirst());
    }
}
