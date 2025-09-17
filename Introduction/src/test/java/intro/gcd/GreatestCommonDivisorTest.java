package intro.gcd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreatestCommonDivisorTest {

    @Test
    void test_GCD_WhenOneNumberIsZero(){
        assertEquals(10, GreatestCommonDivisor.findGreatestCommonDivisor(0, 10));
    }

    @Test
    void test_GCD_WhenBothNumberAreZero(){
        Exception ex = assertThrows(IllegalStateException.class, () -> GreatestCommonDivisor.findGreatestCommonDivisor(0, 0));

        assertEquals("Both numbers can not be 0", ex.getMessage());
    }

    @Test
    void test_GCD_WithOneNegativeNumber(){
        assertEquals(3, GreatestCommonDivisor.findGreatestCommonDivisor(-9, 3));
    }

    @Test
    void test_GCD_WithBothNegativeNumbers(){
        assertEquals(3, GreatestCommonDivisor.findGreatestCommonDivisor(-9, -3));
    }

    @Test
    void test_GCD_WithDifferentNumbers(){
        assertEquals(1, GreatestCommonDivisor.findGreatestCommonDivisor(13, 17));
    }

    @Test
    void test_LCM_WhenOneNumberAreZero(){
        assertEquals(0, GreatestCommonDivisor.findLeastCommonMultiple(0,10));
    }

    @Test
    void test_LCM_WhenBothNumbersAreZero(){
        assertEquals(0, GreatestCommonDivisor.findLeastCommonMultiple(0,0));
    }

    @Test
    void test_LCM_WithOneNegativeNumber(){
        assertEquals(9, GreatestCommonDivisor.findLeastCommonMultiple(-9, 3));
    }

    @Test
    void test_LCM_WithBothNegativeNumbers(){
        assertEquals(9, GreatestCommonDivisor.findLeastCommonMultiple(-9, -3));
    }
}
