package threads.synchronizedstack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListOfElements {
    private static final Logger LOG = LoggerFactory.getLogger(ListOfElements.class);

    private final Object lock = new Object();
    private final Object[] elements;
    private int numberOfElements;
    private final int capacity;

    public ListOfElements(int length) {
        this.elements = new Object[length];
        this.capacity = length;
        numberOfElements = 0;
    }

    /**
     * Adds an element in the array and the thread is waiting if the array is full
     * @param obj random element
     */
    public void add(Object obj) {
        synchronized (lock){
            while(numberOfElements == capacity){
                try {
                    LOG.info("Waiting for some space");
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        elements[numberOfElements++] = obj;
        LOG.info("Element added");
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    /**
     * Removes the last element in the array and thread is waiting if the array is empty
     */
    public void remove() {
        synchronized (lock){
            while(numberOfElements == 0){
                try {
                    LOG.info("Waiting for some elements");
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        elements[numberOfElements-- - 1] = null;
        LOG.info("Element removed");
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    /**
     * Prints the array
     * @return String representation of the array
     */
    @Override
    public String toString() {
        if (numberOfElements == 0) {
            return "The array is empty!";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfElements; i++) {
            sb.append(elements[i].toString()).append(" ");
        }
        return sb.toString();
    }
}