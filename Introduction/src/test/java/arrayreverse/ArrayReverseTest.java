package intro.arrayreverse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayReverseTest {
    @Test
    void test_ArrayReverse_Throws_WhenArrayIsEmpty(){
        int[] arr = {};
        assertThrows(IllegalStateException.class, () -> ArrayReverse.Reverse(arr));
    }

    @Test
    void test_ArrayReverse_WhenEvenCountNumbers(){
        int[] arr = {1, 2, 3, 4, 5, 6};
        assertEquals("6 5 4 3 2 1 ", ArrayReverse.Reverse(arr));
    }

    @Test
    void test_ArrayReverse_WhenOddCountNumbers(){
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        assertEquals("7 6 5 4 3 2 1 ", ArrayReverse.Reverse(arr));
    }
}
