package designpatterns.observer;

import nl.altindag.log.LogCaptor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConcreteObserverTest {
    private static Observer observer;
    @BeforeEach
    void setUp(){
        observer = new ConcreteObserver(10);
    }

    @Test
    void testUpdateCorrectWhenAddingGood(){
        LogCaptor captor = LogCaptor.forClass(ConcreteObserver.class);

        observer.update("Added");

        Assertions.assertEquals("Good added", captor.getInfoLogs().getFirst());
    }

    @Test
    void testUpdateCorrectWhenSellingGood(){
        LogCaptor captor = LogCaptor.forClass(ConcreteObserver.class);

        observer.update("Sold");

        Assertions.assertEquals("Good sold", captor.getInfoLogs().getFirst());
    }
}
