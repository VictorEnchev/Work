package reflectionannotationsregex.displayprivatefieldsvaluesandcallprivatefieldmethods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Experimental child class that inherit another and invoke its private methods and extract its fieds
 */
public class ChildClass extends PrivateClass {
    private static final Logger LOG = LoggerFactory.getLogger(ChildClass.class);
    private final Class<?> clazz;

    public ChildClass(int intField, String stringFiled, char charField) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        super(intField, stringFiled, charField);
        clazz = PrivateClass.class;
    }

    /**
     * Invoke specifically this method from the other class
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void callPrivateVoid() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method voidMethod = clazz.getDeclaredMethod("voidMethod");
        voidMethod.setAccessible(true);
        voidMethod.invoke(this);
    }

    /**
     * Invoke specifically this method from the other class
     * @return what the method in the mother's class return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     */
    public Object callIntMethod() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method voidMethod = clazz.getDeclaredMethod("intMethod");
        voidMethod.setAccessible(true);
        return voidMethod.invoke(this);
    }

    /**
     * Invoke specifically this method from the other class
     * @return what the method in the mother's class return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     */
    public Object callStringMethod() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method voidMethod = clazz.getDeclaredMethod("stringMethod");
        voidMethod.setAccessible(true);
        return voidMethod.invoke(this);
    }

    /**
     * Invoke specifically this method from the other class
     * @return what the method in the mother's class return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     */
    public Object callCharMethod() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method voidMethod = clazz.getDeclaredMethod("charMethod");
        voidMethod.setAccessible(true);
        return voidMethod.invoke(this);
    }

    /**
     * Prints the value of echa field of the mother class
     * @throws IllegalAccessException
     */
    public void displayPrivateFieldsValues() throws IllegalAccessException {
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            f.setAccessible(true);
            LOG.info(f.get(this) + " ");
        }
    }
}
