package threads.producerconsumer;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Warehouse warehouse = new Warehouse(3);

        Producer producer = new Producer(3, warehouse);
        Trader trader = new Trader(15, warehouse);
        producer.start();
        trader.start();
        producer.setDaemon(true);
        trader.setDaemon(true);

        Thread.sleep(60000);
    }
}
