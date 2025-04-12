package intro.arrayproccessing;

import ch.qos.logback.core.testUtil.MockInitialContext;
import ch.qos.logback.core.testUtil.MockInitialContextFactory;
import com.onto.javacourse.intro.arrayprocessing.ArrayProcessing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ArrayProcessingTest {
    @Test
    void test_ArrayProcessing_getMinElementIndex_WithTwoIdenticalSmallestValues(){
        int[] arr  = {2, 1, 3, 5, 6, 3, 1};
        assertEquals(1, ArrayProcessing.getMinElementIndex(arr));
    }

    @Test
    void test_ArrayProcessing_getMinElementIndex_WithAllIdenticalValues(){
        int[] arr  = {1, 1, 1, 1, 1, 1, 1};
        assertEquals(0, ArrayProcessing.getMinElementIndex(arr));
    }

    @Test
    void test_ArrayProcessing_getMinElementIndex_ThrowsWhenArrayIsEmpty(){
        int[] arr  = {};
        assertThrows(IllegalStateException.class,() -> ArrayProcessing.getMinElementIndex(arr));
    }

    @Test
    void test_ArrayProcessing_Sum_WithRandomValues(){
        int[] arr  = {2, 1, 3, 5, 6, 3, 1};
        assertEquals(21, ArrayProcessing.sum(arr));
    }

    @Test
    void test_ArrayProcessing_Sum_ThrowsWhenArrayIsEmpty(){
        int[] arr  = {};
        assertThrows(IllegalStateException.class,() -> ArrayProcessing.sum(arr));
    }

    @Test
    void test_ArrayProcessing_Print_ThrowsWhenArrayIsEmpty(){
        int[] arr  = {};
        assertThrows(IllegalStateException.class,() -> ArrayProcessing.print(arr));
    }
}
