package reflectionannotationsregex.displayprivatefieldsvaluesandcallprivatefieldmethods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Random class with random private fields and methods
 */
public class PrivateClass {
    private static final Logger LOG = LoggerFactory.getLogger(PrivateClass.class);

    private int intField;
    private String stringFiled;
    private char charField;

    public PrivateClass(int intField, String stringFiled, char charField) {
        this.intField = intField;
        this.stringFiled = stringFiled;
        this.charField = charField;
    }

    private void voidMethod(){LOG.info("Hello from void method!");}
    private int intMethod(){return 123456789;}
    private String stringMethod(){return "Hello from string method!";}
    private char charMethod(){return 'v';}
}
