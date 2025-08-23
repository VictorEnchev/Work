package collections.lrucache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        CacheManger lru = new CacheManger(4);
        lru.search("viktor");
        lru.search("pedal");
        lru.search("rosen");
        lru.search("viktor");
        lru.search("pedal");
        lru.search("mabel");
        LOG.info(lru.printSearch());
    }
}
