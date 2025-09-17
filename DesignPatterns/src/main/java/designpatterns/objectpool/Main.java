package designpatterns.objectpool;

public class Main {
    public static void main(String[] args) {
        Pool<Integer> pool = new Pool<>(10);

        for (int i = 0; i < 10; i++) {
            pool.acquire(i);
        }
        pool.release();
        pool.acquire(11);
    }
}
