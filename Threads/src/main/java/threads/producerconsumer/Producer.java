package threads.producerconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Producer which make goods for the warehouse
 */
public class Producer extends Thread{
    private static final Logger LOG = LoggerFactory.getLogger(Producer.class);

    private final Warehouse warehouse;
    private final int timeProduce;

    public Producer(int timeProduce, Warehouse warehouse){
        this.timeProduce = timeProduce;
        this.warehouse = warehouse;
    }

    /**
     * Produce good when there is available space in the storage, otherwise it is waiting for some space to free up
     */
    @Override
    public void run() {
        while(true) {
            LOG.info("Waiting to produce good...");
            for (int i = 0; i < timeProduce; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            synchronized (warehouse){
                warehouse.notifyAll();
                warehouse.produce("p" + 1);
            }
        }
    }
}
