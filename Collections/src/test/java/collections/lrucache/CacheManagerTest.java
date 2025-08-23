package collections.lrucache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CacheManagerTest {
    private CacheManger lru;

    @BeforeEach
    void setUp(){
        lru = new CacheManger(4);
        lru.search("apple");
        lru.search("pear");
        lru.search("grape");
    }

    @Test
    void testPrintSearchCorrectPrinting(){
        StringBuilder sb = new StringBuilder();
        sb.append("grape").append(System.lineSeparator())
                .append("pear").append(System.lineSeparator())
                .append("apple").append(System.lineSeparator());

        assertEquals(sb.toString(), lru.printSearch());
    }
    @Test
    void testSearchCorrectRearrangingItemInSearchList(){
        lru.search("pear");

        StringBuilder sb = new StringBuilder();
        sb.append("pear").append(System.lineSeparator())
                .append("grape").append(System.lineSeparator())
                .append("apple").append(System.lineSeparator());

        assertEquals(sb.toString(), lru.printSearch());
    }

    @Test
    void testSearchCorrectRearrangingItemInSearchListWhenAddedNewItem(){
        lru.search("peach");

        StringBuilder sb = new StringBuilder();
        sb.append("peach").append(System.lineSeparator())
                .append("grape").append(System.lineSeparator())
                .append("pear").append(System.lineSeparator())
                .append("apple").append(System.lineSeparator());


        assertEquals(sb.toString(), lru.printSearch());
    }

    @Test
    void testSearchThrowsWhenOverCapacity(){
        lru.search("peach");

        assertThrows(IllegalCallerException.class, () -> lru.search("labubu"));
    }
}
