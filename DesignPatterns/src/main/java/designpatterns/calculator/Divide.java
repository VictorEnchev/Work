package designpatterns.calculator;

/**
 * Specific division command which divides two passed numbers
 */
public class Divide implements Command{
    private final double number1;
    private final double number2;

    public Divide(double number1, double number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    /**
     * Divides number1 by number2
     * @return the result of the division
     * @throws IllegalArgumentException if the second number is 0
     */
    @Override
    public double execute() {
        if(number2 == 0){
           throw new IllegalArgumentException("Can not divide by 0!");
        }
        return number1 / number2;
    }
}
