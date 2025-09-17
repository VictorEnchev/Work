package threads.producerconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 *  Storage for goods
 */
public class Warehouse {
    private static final Logger LOG = LoggerFactory.getLogger(Warehouse.class);

    private final int capacity;
    private final List<Object> goods;

    public Warehouse(int capacity) {
        this.capacity = capacity;
        this.goods = new ArrayList<>();
    }

    /**
     * Produce goods when invoked or waits if the storage is full
     * @param good Object to be added
     */
    public void produce(Object good) {
        synchronized (this) {
            while (goods.size() == capacity) {
                try {
                    LOG.info("No space for more goods");
                    LOG.info("Waiting for the trader to buy something...");
                    this.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        goods.add(good);
        LOG.info("Product produced!");
    }

    /**
     * Sell goods when invoked and waits if there are not any goods available
     */
    public void sell() {
        synchronized (this) {
            while (goods.isEmpty()) {
                try {
                    LOG.info("No goods in the warehouse to sell");
                    LOG.info("Waiting for the producer to make something...");
                    this.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        goods.removeFirst();
        LOG.info("Product sold!");
    }
}
