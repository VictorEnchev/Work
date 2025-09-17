package threads.stopcounterthread;

import nl.altindag.log.LogCaptor;
import org.junit.jupiter.api.BeforeEach;

// I do not know how to test threads, especially with a user input
class CounterThreadTest {
    private Thread counterThread;
    private final LogCaptor captor = LogCaptor.forClass(CounterThread.class);

    @BeforeEach
    void setUp(){
        counterThread = new Thread(new CounterThread(10));
    }

//    @Test
//    void testCorrectExecutingWhenBelowTimeLimit(){
//        counterThread.start();
//        String input = "d";
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//        counterThread.interrupt();
//
//        Assertions.assertEquals(1, captor.getInfoLogs().get(1));
//    }
}
