package designpatterns.objectpool;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class PoolTest {
    @Test
    void testAcquireThrowsWhenOverLimit(){
        Pool<Integer> pool = new Pool<>(1);

        pool.acquire(1);

        Exception ex = assertThrows(IllegalCallerException.class, () -> pool.acquire(2));
        assertEquals("No free resources!", ex.getMessage());
    }

    @Test
    void testReleaseRemovesCorrectlyIfListIsEmpty() {
        Pool<Integer> pool = new Pool<>(10);

        assertDoesNotThrow(pool::release);
    }
}
