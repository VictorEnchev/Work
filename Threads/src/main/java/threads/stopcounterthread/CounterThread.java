package threads.stopcounterthread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Thread class which counts the for the execution of a specific task
 */
public class CounterThread implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(CounterThread.class);
    private final int maxSeconds;

    public CounterThread(int maxSeconds) {
        this.maxSeconds = maxSeconds;
    }

    /**
     * Counts the time for the execution of a specific task and prints the needed time for the operation on the console.
     * If a specific time limit is reached, appropriate message is shown on the terminal.
     */
    @Override
    public void run() {
        for (int i = 1; i <= maxSeconds; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                LOG.info("You did the task for %d seconds".formatted(i));
                Thread.currentThread().interrupt();
                break;
            }

            if (i == maxSeconds) {
                LOG.info("Time is up");
                System.exit(0);
            }
        }
    }
}
