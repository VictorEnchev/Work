package designpatterns.abstractfactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Factory class following the Factory Design pattern using reflection for getting an instance
 */
public class MyClassFactoryReflection {
    public Object createInstance(String field, String className){
        try {
            Class<?> clazz = Class.forName(className);
            Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(String.class);
            return declaredConstructor.newInstance(field);
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public Object createInstance(String className){
        try {
            Class<?> clazz = Class.forName(className);
            Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
            return declaredConstructor.newInstance();
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
