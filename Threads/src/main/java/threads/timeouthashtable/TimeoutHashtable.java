package threads.timeouthashtable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Hashtable class which removes entries after a certain time
 */
public class TimeoutHashtable {
    private static final Logger LOG = LoggerFactory.getLogger(TimeoutHashtable.class);

    private final Hashtable<String, Object> table;
    private final HashMap<String, TrackerThread> threads;
    private final int secondsToStore;

    public TimeoutHashtable(int secondsToStore) {
        this.table = new Hashtable<>();
        this.secondsToStore = secondsToStore;
        this.threads = new HashMap<>();
    }

    /**
     * Puts new entry to table or updates an already existing key, and creates a new thread for each key
     * @param key the key of the pair
     * @param value the value of the pair
     */
    public void put(String key, Object value){
        if(table.containsKey(key)) threads.get(key).awake();
        else {
            LOG.info("New value was put and a thread was created");
            table.put(key, value);
            TrackerThread thread = new TrackerThread(secondsToStore);
            thread.start();
            thread.setName(key);
            thread.setDaemon(true);
            threads.put(key, thread);
        }
    }

    /**
     * Returns a value by key if existing and refreshes the clock of the thread
     * @param key key of the pair
     * @return value of the pair
     */
    public Object get(String key){
        if(table.containsKey(key)) threads.get(key).awake();
        return table.get(key);
    }

    /**
     * Removes a value by key together with its personal thread
     * @param key of the pair
     * @return value of the pair
     */
    public Object remove(String key){
        LOG.info("Key %s has been removed".formatted(key));
        threads.get(key).interrupt();
        threads.remove(key);
        return table.remove(key);
    }
}
