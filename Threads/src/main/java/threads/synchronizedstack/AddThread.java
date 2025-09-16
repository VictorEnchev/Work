package threads.synchronizedstack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static threads.synchronizedstack.Main.input;

/**
 * Thread which adds elements to a custom list class
 */
public class AddThread implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(AddThread.class);
    private final ListOfElements list;

    public AddThread(ListOfElements list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (!"End".equals(input)) {
            if ("Add".equals(input.split(" ")[0])) {
                LOG.info("Just read the value and should have been added");
                list.add(input.split(" ")[1]);
                input = "";
            }
        }
    }
}
