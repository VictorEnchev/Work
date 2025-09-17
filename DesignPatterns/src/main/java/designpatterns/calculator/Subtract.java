package designpatterns.calculator;

/**
 * Specific subtract command which subtracts two passed numbers
 */
public class Subtract implements Command {
    private final double number1;
    private final double number2;

    public Subtract(double number1, double number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    /**
     * Subtract number2 from number1
     * @return the differance
     */
    @Override
    public double execute() {
        return number1 - number2;
    }
}
