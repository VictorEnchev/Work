package threads.sleepingcounters;

import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) {
        AtomicBoolean flag = new AtomicBoolean(false);
        Thread thread1 = new Thread(new CounterThreadSleep(6,1000, flag, 500));
        thread1.setName("Sleep");
        Thread thread2 = new Thread(new CounterThreadWait(6, 1000, flag, 500));
        thread2.setName(" Wait");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
