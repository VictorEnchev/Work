package designpatterns.objectpool;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class representing an instance manager which manages the crated number of objects from one type
 * @param <T> specific object type
 */
public class Pool<T> {
    private final int limit;
    private Queue<T> objects;

    public Pool(int limit) {
        this.limit = limit;
        this.objects = new LinkedList<>();
    }

    /**
     * Adds another object to the collection if it is possible
     * @param object object given from the client
     */
    public void acquire(T object){
        if(objects.size() >= limit){
            throw new IllegalCallerException("No free resources!");
        }
        objects.add(object);
    }

    /**
     * Removes the first object that has gone into the collection if there is one
     */
    public void release(){
        if(!objects.isEmpty()){
            objects.poll();
        }
    }
}
