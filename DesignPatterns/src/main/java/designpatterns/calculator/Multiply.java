package designpatterns.calculator;

/**
 * Specific multiplication command which multiplies two passed numbers
 */
public class Multiply implements Command{
    private final double number1;
    private final double number2;

    public Multiply(double number1, double number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    /**
     * Multiplies number1 and number2
     * @return the product
     */
    @Override
    public double execute() {
        return number1 * number2;
    }
}
