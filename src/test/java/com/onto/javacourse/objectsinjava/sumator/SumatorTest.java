package com.onto.javacourse.objectsinjava.sumator;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumatorTest {
    @Test
    void testSumIntegerWithRandomValues(){
        assertEquals(8, Sumator.sum(3, 5));
    }

    @Test
    void testSumDoubleWithRandomValues(){
        assertEquals(9.0, Sumator.sum(3.3, 5.7));
    }

    @Test
    void testSumStringWithRandomValues(){
        assertEquals("8", Sumator.sum("3", "5"));
    }

    @Test
    void testSumBigIntegerWithRandomValues(){
        assertEquals(BigInteger.valueOf(8), Sumator.sum(BigInteger.valueOf(3), BigInteger.valueOf(5)));
    }

    @Test
    void testSumBigDecimalWithRandomValues(){
        assertEquals(BigDecimal.valueOf(9.0), Sumator.sum(BigDecimal.valueOf(3.3), BigDecimal.valueOf(5.7)));
    }
}
