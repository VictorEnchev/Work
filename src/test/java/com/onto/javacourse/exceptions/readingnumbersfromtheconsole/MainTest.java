package com.onto.javacourse.exceptions.readingnumbersfromtheconsole;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void testReadNumberThrowsWhenNumberBelowZero(){
        Exception ex = assertThrows(InvalidInputException.class, () -> Main.readNumber(-1));
        assertEquals("Number should be between 0 and 100", ex.getMessage());
    }

    @Test
    void testReadNumberThrowsWhenNumberBeyondZero(){
        Exception ex = assertThrows(InvalidInputException.class, () -> Main.readNumber(101));
        assertEquals("Number should be between 0 and 100", ex.getMessage());
    }

    @Test
    void testReadNumberThrowsWhenNumberInRange() throws InvalidInputException {
        assertEquals("You entered: 0,00", Main.readNumber(0));
    }
}
