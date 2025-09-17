package threads.stopcounterthread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);
    private static boolean stop = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LOG.info("Enter the maximum seconds: ");
        int maxSeconds = Integer.parseInt(scanner.nextLine());
        Thread counterThread = new Thread(new CounterThread(maxSeconds));
        counterThread.start();

        LOG.info("You have " + maxSeconds + " seconds to type something");
        String keyboardEvent = scanner.nextLine();
        counterThread.interrupt();

        scanner.close();
    }
}
