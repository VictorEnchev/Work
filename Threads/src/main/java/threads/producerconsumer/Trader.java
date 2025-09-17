package threads.producerconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Trader who buy goods from the warehouse
 */
public class Trader extends Thread{
    private static final Logger LOG = LoggerFactory.getLogger(Trader.class);

    private final Warehouse warehouse;
    private final int timeSell;

    public Trader(int timeProduce, Warehouse warehouse){
        this.timeSell = timeProduce;
        this.warehouse = warehouse;
    }

    /**
     * Buy goods from the warehouse when there is available, otherwise it is waiting to restock
     */
    @Override
    public void run() {
        while(true) {
            LOG.info("Trader is wondering what to buy...");
            for (int i = 0; i < timeSell; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            synchronized (warehouse){
                warehouse.notifyAll();
                warehouse.sell();
            }
        }
    }
}
