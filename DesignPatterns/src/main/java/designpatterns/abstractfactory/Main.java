package designpatterns.abstractfactory;

public class Main {
    public static void main(String[] args) {
        MyClassFactory factory = new MyClassFactory();
        MyClass instance1 = factory.createInstance();
        MyClass instance2 = factory.createInstance("field");

        MyClassFactoryReflection factoryReflection = new MyClassFactoryReflection();
        Object instanceReflection1 = factoryReflection.createInstance("MyClass");
        Object instanceReflection2 = factoryReflection.createInstance("field", "MyClass");
    }
}
