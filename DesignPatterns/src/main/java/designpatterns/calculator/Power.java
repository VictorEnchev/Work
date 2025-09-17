package designpatterns.calculator;

/**
 * Specific power command which powers the first passed number
 */
public class Power implements Command{
    private final double number;
    private final int power;

    public Power(double number, int power) {
        this.number = number;
        this.power = power;
    }

    /**
     * Powers the given number
     * @return the result of the power
     */
    @Override
    public double execute() {
        return Math.pow(number, power);
    }
}
