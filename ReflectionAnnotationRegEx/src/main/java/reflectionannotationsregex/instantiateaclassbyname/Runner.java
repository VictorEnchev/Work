package reflectionannotationsregex.instantiateaclassbyname;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Runner {
    private static final Logger LOG = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object someClass = SomeClass.class.getConstructor(int.class).newInstance(2);

        printClassName(someClass);
        printInterfaceName(someClass);
    }

    /**
     * Prints the name of all interfaces which the current parent class is implementing
     * @param someClass random object of random class
     */
    public static void printInterfaceName(Object someClass) {
        Arrays.stream(someClass.getClass().getInterfaces()).forEach(i -> {
            int counter = 1;
            LOG.info("Name of interface %d: %s".formatted(counter, i.getSimpleName()));
        });
    }

    /**
     * Prints the name of the class of the given object
     * @param someClass random object of random class
     */
    public static void printClassName(Object someClass) {
        LOG.info("Name of the parent class: %s".
                formatted(someClass.
                        getClass().
                        getSimpleName()
                )
        );
    }
}
