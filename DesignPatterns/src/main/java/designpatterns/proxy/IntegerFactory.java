package designpatterns.proxy;

/**
 * Factory class for the IntegerProxy class
 */
public class IntegerFactory {
    public static IntegerProxy createInstance(Integer value){
        return new IntegerProxy(value);
    }
}
