package designpatterns.abstractfactory;

/**
 *  Factory class following the Factory Design pattern
 */
public class MyClassFactory {
    public MyClass createInstance(String field){
        return new MyClass(field);
    }

    public MyClass createInstance(){
        return new MyClass();
    }
}
