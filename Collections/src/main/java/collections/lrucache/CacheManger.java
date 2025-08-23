package collections.lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Operates with data in a cache based on the LRU principle
 */
public class CacheManger {
    private LinkedHashMap<String, String> cache;
    private final int capacity;

    public CacheManger(int capacity) {
        this.cache = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    /**
     * Mocks the "search" command in browsers and decides whether it should add new element or put it first in the searching list
     * @param item the item which is searched
     * @throws IllegalCallerException if the storage in the cache is full
     */
    public void search(String item){
        if(cache.containsKey(item)) {
            cache.remove(item);
            cache.putFirst(item, item);
        }
        else{
            if(cache.size() >= capacity){
                throw new IllegalCallerException("Can not add item due to overflowing");
            }
            cache.putFirst(item, item);
        }
    }

    /**
     * Prints the list of the searched items
     * @return String representation of the collection
     */
    public String printSearch(){
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : cache.entrySet()){
            sb.append(entry.getValue()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
