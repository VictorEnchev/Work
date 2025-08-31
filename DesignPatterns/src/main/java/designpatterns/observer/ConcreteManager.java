package designpatterns.observer;

/**
 * Manages the sold and available items and notifies the observers when needed
 */
public class ConcreteManager implements Manager {
    private final Observer observer;

    public ConcreteManager(int goodsCount) {
        this.observer = new ConcreteObserver(goodsCount);
    }

    /**
     * Notifies the observer when a change occurs
     * @param actionType marks whether a good is sold or added
     */
    @Override
    public void notifyObserver(String actionType) {
        observer.update(actionType);
    }

    /**
     * Notify the observer that a good is added
     */
    @Override
    public void addGood() {
        notifyObserver("Added");
    }

    /**
     * Notify the observer that a good is sold
     */
    @Override
    public void sellGood() {
        notifyObserver("Sold");
    }

}
