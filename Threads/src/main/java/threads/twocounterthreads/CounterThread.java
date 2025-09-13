package threads.twocounterthreads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Thread class which counts to a specific number through given interval of milliseconds
 */
public class CounterThread implements Runnable{
    private static final Logger LOG = LoggerFactory.getLogger(CounterThread.class);

    private final int intervalEnd;
    private final int intervalMillis;
    private final AtomicBoolean stopFlag;

    public CounterThread(int intervalEnd, int intervalMillis, AtomicBoolean stopFlag) {
        this.intervalEnd = intervalEnd;
        this.intervalMillis = intervalMillis;
        this.stopFlag = stopFlag;
    }

    /**
     * Counts to given number and is interrupted when another concurrency thread finishes counting first
     */
    @Override
    public void run() {
        try {
            for (int i = 1; i <= intervalEnd; i++) {
                if (stopFlag.get()){
                    LOG.info("In " + Thread.currentThread().getName() + ": Other thread has finished counting!");
                    Thread.currentThread().interrupt();
                    Thread.sleep(1);
                }
                LOG.info("%s: %d seconds".formatted(Thread.currentThread().getName(), i));
                Thread.sleep(intervalMillis);
            }
            LOG.info(Thread.currentThread().getName() + " finished counting!");
            stopFlag.set(true);
        }
        catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }
}