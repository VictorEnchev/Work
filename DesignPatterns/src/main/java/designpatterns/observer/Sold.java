package designpatterns.observer;

/**
 * Class representing the number of sold goods
 */
public class Sold {
    private int count;

    /**
     * Increases the count when a good is sold
     */
    public void sellGood() {
        count++;
    }
}
