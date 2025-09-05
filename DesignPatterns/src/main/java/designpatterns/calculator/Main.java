package designpatterns.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        LOG.info(calculator.executeCommand(new Add(3, 4)) + "");
        LOG.info(calculator.executeCommand(new Subtract(3, 4)) + "");
        LOG.info(calculator.executeCommand(new Multiply(3, 4)) + "");
        LOG.info(calculator.executeCommand(new Divide(3, 0)) + "");
        LOG.info(calculator.executeCommand(new Power(3, 4)) + "");
    }
}
