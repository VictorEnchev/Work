package designpatterns.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MultiplyTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testMultiplyCorrectExecuting() {
        Assertions.assertEquals(12, calculator.executeCommand(new Multiply(3, 4)));
    }
}
