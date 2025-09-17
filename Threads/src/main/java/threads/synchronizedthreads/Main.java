package threads.synchronizedthreads;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new SynchronizedCounterThread(5));
        t1.setName("t1");
        Thread t2 = new Thread(new SynchronizedCounterThread(5));
        t2.setName(" t2");
        Thread t3 = new Thread(new SynchronizedCounterThread(5));
        t3.setName("  t3");
        Thread t4= new Thread(new SynchronizedCounterThread(5));
        t4.setName("   t4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
