package threads.synchronizedstack;

import java.util.Scanner;

public class Main {
    protected static volatile String input = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListOfElements list = new ListOfElements(5);

        AddThread add = new AddThread(list);
        Thread addThread = new Thread(add);
        RemoveThread remove = new RemoveThread(list);
        Thread removeThread = new Thread(remove);

        addThread.start();
        removeThread.start();

        String consoleInput = scanner.nextLine();
        while(!input.equals("End")){
            input = consoleInput;
            consoleInput = scanner.nextLine();
        }
        input = "End";

        try {
            addThread.join();
            removeThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
