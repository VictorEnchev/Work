package com.onto.javacourse.intro.summinglargenumbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SummingLargeNumbersTest {
    @Test
    void test_SumLargeNumbers_WhenFirstNumberIsBigger(){
        assertEquals("1246912", SummingLargeNumbers.sumLargeNumbers("1234567", "12345"));
    }

    @Test
    void test_SumLargeNumbers_WhenSecondNumberIsBigger(){
        assertEquals("1246912", SummingLargeNumbers.sumLargeNumbers("12345", "1234567"));
    }

    @Test
    void test_SumLargeNumbers_WhenNumbersAreEqual(){
        assertEquals("2469134", SummingLargeNumbers.sumLargeNumbers("1234567", "1234567"));
    }

    @Test
    void test_SumLargeNumbers_Throws_WhenNumbersAreEmpty(){
        Exception ex = assertThrows(IllegalStateException.class,() -> SummingLargeNumbers.sumLargeNumbers("", ""));
        assertEquals("Numbers can not be empty", ex.getMessage());
    }

    @Test
    void test_SumLargeNumbers_Throws_WhenNotNumbers(){
        Exception ex = assertThrows(IllegalStateException.class,() -> SummingLargeNumbers.sumLargeNumbers("783236akr72", "96435892"));
        assertEquals("You must enter number", ex.getMessage());
    }
}
