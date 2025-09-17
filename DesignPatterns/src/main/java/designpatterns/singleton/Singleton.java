package designpatterns.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class representing the Singleton design pattern
 */
public class Singleton {
    private static final Logger LOG = LoggerFactory.getLogger(Singleton.class);
    private static Singleton instance;

    private Singleton() {
        LOG.info("Singleton created!");
    }

    /**
     * Returns the single instance of this class and creates one if needed
     * @return instance of this class
     */
    public static Singleton getInstance(){
        if(Singleton.instance == null) instance = new Singleton();
        return instance;
    }
}
