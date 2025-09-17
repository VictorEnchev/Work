package designpatterns.observer;

/**
 * Class representing the number of available goods
 */
public class Available {
    private int count;

    public Available(int count) {
        this.count = count;
    }

    /**
     * Increases the count when a good is added
     */
    public void addGood() {
        count++;
    }

    /**
     * Decreases the count when a good is sold
     */
    public void sellGood() {
        count--;
    }
}
