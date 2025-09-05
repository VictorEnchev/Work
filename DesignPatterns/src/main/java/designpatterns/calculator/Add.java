package designpatterns.calculator;

/**
 * Specific add command which adds two passed numbers
 */
public class Add implements Command{
    private final double number1;
    private final double number2;

    public Add(double number1, double number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    /**
     * Add number1 and number2
     * @return the sum
     */
    @Override
    public double execute() {
        return number1 + number2;
    }
}
