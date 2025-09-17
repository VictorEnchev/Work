package designpatterns.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PowerTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testPowerCorrectExecuting() {
        Assertions.assertEquals(81, calculator.executeCommand(new Divide(3, 4)));
    }
}
