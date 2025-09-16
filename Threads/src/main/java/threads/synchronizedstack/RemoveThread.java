package threads.synchronizedstack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static threads.synchronizedstack.Main.input;

/**
 * Thread which removes elements from a custom list class
 */
public class RemoveThread implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(RemoveThread.class);
    private final ListOfElements list;

    public RemoveThread(ListOfElements list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (!"End".equals(input)) {
            if ("Remove".equals(input.split( " ")[0])) {
                LOG.info("Just read the input and should have been removed");
                list.remove();
                input = "";
            }
        }
    }
}

