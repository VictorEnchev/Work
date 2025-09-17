package designpatterns.observer;

import nl.altindag.log.LogCaptor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConcreteManagerTest {
    private Manager manager;
    private LogCaptor captor;

    @BeforeEach
    void setUp() {
        captor = LogCaptor.forClass(ConcreteObserver.class);
        manager = new ConcreteManager(12);
    }

    @Test
    void testNotifyObserverCorrectNotifying() {
        manager.notifyObserver("Added");

        Assertions.assertEquals("Good added", captor.getInfoLogs().getFirst());
    }

    @Test
    void testAddGoodCorrectNotifying() {
        manager.addGood();

        Assertions.assertEquals("Good added", captor.getInfoLogs().getFirst());
    }

    @Test
    void testSellGoodCorrectNotifying() {
        manager.sellGood();

        Assertions.assertEquals("Good sold", captor.getInfoLogs().getFirst());
    }

}
