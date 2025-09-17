package designpatterns.observer;

/**
 * Interface with the mandatory methods for the manager class
 */
public interface Manager {
    public void notifyObserver(String actionType);

    public void addGood();

    public void sellGood();
}
