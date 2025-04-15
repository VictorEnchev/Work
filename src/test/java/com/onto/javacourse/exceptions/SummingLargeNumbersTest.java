package com.onto.javacourse.exceptions;

import com.onto.javacourse.exceptions.sumator.SummingLargeNumbers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SummingLargeNumbersTest {
    @Test
    void testSumLargeNumbersThrowsWhenNumbersAreEmpty(){
        String num1 = "";
        String num2 = "";
        IllegalStateException ex = assertThrows(IllegalStateException.class, () -> SummingLargeNumbers.sumLargeNumbers(num1, num2));
        assertEquals("Numbers can not be empty", ex.getMessage());
    }

    @Test
    void testSumLargeNumbersThrowsWhenNumbersAreNotNumbers(){
        String num1 = "8034t";
        String num2 = "mvoa";
        IllegalStateException ex = assertThrows(IllegalStateException.class, () -> SummingLargeNumbers.sumLargeNumbers(num1, num2));
        assertEquals("Numbers should contain only digits!", ex.getMessage());
    }

    //....other tests that are have been made in the previous task
}
