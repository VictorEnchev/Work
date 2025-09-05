package designpatterns.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AddTest {
    private Calculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }

    @Test
    void testAddCorrectExecuting(){
        Assertions.assertEquals(7, calculator.executeCommand(new Add(3, 4)));
    }
}
