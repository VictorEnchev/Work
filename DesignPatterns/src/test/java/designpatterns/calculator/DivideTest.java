package designpatterns.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DivideTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testDivideCorrectExecuting() {
        Assertions.assertEquals(0.75, calculator.executeCommand(new Divide(3, 4)));
    }

    @Test
    void testDivideThrowsWhen0() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.executeCommand(new Divide(3, 0)));
    }
}
