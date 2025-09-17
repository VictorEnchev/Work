package designpatterns.observer;

/**
 * Interface with the mandatory methods for every observer that is being created
 */
public interface Observer {
    public void update(String actionType);
}
