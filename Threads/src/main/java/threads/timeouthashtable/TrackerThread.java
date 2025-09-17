package threads.timeouthashtable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Tracks the existence of a variable for a certain amount of time and delete it afterwords
 */
public class TrackerThread extends Thread {
    private static final Logger LOG = LoggerFactory.getLogger(TrackerThread.class);

    private final Object lock = new Object();
    private final TimeoutHashtable table;
    private final int secondsToStore;
    private volatile boolean isAwoken;

    public TrackerThread(int secondsToStore) {
        this.secondsToStore = secondsToStore;
        this.table = new TimeoutHashtable(secondsToStore);
    }

    @Override
    public void run() {
        boolean isDead = false;
        while (!isDead) {
            isAwoken = false;
            synchronized (lock) {
                try {
                    lock.wait(secondsToStore * 1000L);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            if (!isAwoken) isDead = true;
            LOG.info("Thread: \"%s\" is awake".formatted(Thread.currentThread().getName()));

        }
        LOG.info("Key has not been used for a long time. It will be removed from the table");
        table.remove(Thread.currentThread().getName());
    }

    public void awake() {
        LOG.info("Thread: \"%s\" should be awake".formatted(Thread.currentThread().getName()));
        this.isAwoken = true;
        synchronized (lock) {
            lock.notifyAll();
        }
    }
}
