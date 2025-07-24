package reflectionannotationsregex.displayprivatefieldsvaluesandcallprivatefieldmethods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;

public class Runner {
    private static final Logger LOG = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        ChildClass childClass = new ChildClass(35, "12", 'a');
        childClass.callPrivateVoid();
        LOG.info(childClass.callIntMethod() + "");
        LOG.info(childClass.callStringMethod() + "");
        LOG.info(childClass.callCharMethod() + "");
        childClass.displayPrivateFieldsValues();
    }
}
