package designpatterns.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        IntegerProxy proxy = IntegerFactory.createInstance(12);

        LOG.info(proxy.toString());
    }
}
