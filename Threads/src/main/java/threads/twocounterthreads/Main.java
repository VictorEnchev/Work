package threads.twocounterthreads;

import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) {
        AtomicBoolean flag = new AtomicBoolean(false);
        Thread thread1 = new Thread(new CounterThread(6,1000, flag));
        thread1.setName("V");
        Thread thread2 = new Thread(new CounterThread(6, 1000, flag));
        thread2.setName(" T");

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
