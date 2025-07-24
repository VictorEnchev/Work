package reflectionannotationsregex.displayclassinformation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Runner {
    private static final Logger LOG = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {
        RandomClass rc = new RandomClass(2, 3, 4);

        printMethodsInformation(rc);
        printFieldsInformation(rc);
    }

    /**
     * Prints all declared methods of random class
     * @param rc Random class with random fields and methods
     */
    public static <T> void printMethodsInformation(T rc) {
        Method[] declaredMethods = rc.getClass().getDeclaredMethods();
        Arrays.stream(declaredMethods).forEach(m -> m.setAccessible(true));

        Arrays.stream(declaredMethods).forEach(m -> {
            StringBuilder sb = new StringBuilder();
            sb.append(m.getName()).append(": ");
            Arrays.stream(m.getParameterTypes()).forEach(t -> sb.append(t).append(" "));

            LOG.info(sb.toString());
        });
    }

    /**
     * Prints all declared fields together with its types and values
     * @param rc random class with random fields and methods
     */
    public static <T> void printFieldsInformation(T rc) {
        Field[] declaredFields = rc.getClass().getDeclaredFields();
        Arrays.stream(declaredFields).forEach(f -> f.setAccessible(true));

        Arrays.stream(declaredFields).forEach(f -> {
            StringBuilder sb = new StringBuilder();
            try {
                sb.append(f.getName()).append("; ").append(f.getType()).append("; ").append(f.get(rc));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            LOG.info(sb.toString());
        });
    }
}
