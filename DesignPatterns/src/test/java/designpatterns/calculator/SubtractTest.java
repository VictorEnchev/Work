package designpatterns.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SubtractTest {
    private Calculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }

    @Test
    void testSubtractCorrectExecuting(){
        Assertions.assertEquals(-1, calculator.executeCommand(new Subtract(3, 4)));
    }
}
