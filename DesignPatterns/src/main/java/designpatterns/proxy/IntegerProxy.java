package designpatterns.proxy;

/**
 * Proxy class for the Integer class with random useless methods
 */
public class IntegerProxy {
    private final Integer integer;

    IntegerProxy(Integer integer) {
        this.integer = integer;
    }

    public Integer getInteger(){
        return integer;
    }

    public int intValue(){
        return integer;
    }

    @Override
    public String toString() {
        return integer + "";
    }
}
