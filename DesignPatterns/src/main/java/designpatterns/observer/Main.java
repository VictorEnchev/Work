package designpatterns.observer;

public class Main {
    public static void main(String[] args) {
        Manager manager = new ConcreteManager(12);
        manager.addGood();
        manager.sellGood();
    }
}
