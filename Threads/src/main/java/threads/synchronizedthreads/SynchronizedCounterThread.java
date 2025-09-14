package threads.synchronizedthreads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Thread class which counts to a specific number synchronized with other threads
 */
public class SynchronizedCounterThread implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(SynchronizedCounterThread.class);
    private static final Object monitor = new Object();
    private static int numberOfInstances;
    private static AtomicInteger turn = new AtomicInteger(1);

    private final int intervalEnd;
    private final int numberOfCurrentInstance;

    public SynchronizedCounterThread(int intervalEnd) {
        this.intervalEnd = intervalEnd;
        numberOfInstances++;
        numberOfCurrentInstance = numberOfInstances;
    }

    /**
     * Follows the order of creation and counts to a specific number together with other threads without interrupting each other
     */
    @Override
    public void run() {
        for (int i = 1; i <= intervalEnd; i++) {

            synchronized (monitor) {
                while (numberOfCurrentInstance != turn.get()) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }

            LOG.info("In %s: %d seconds".formatted(Thread.currentThread().getName(), i));
            turn.incrementAndGet();
            if (turn.get() > numberOfInstances) {
                turn.set(1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            synchronized (monitor) {
                monitor.notifyAll();
            }
        }
    }
}
