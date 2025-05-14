package reflectionannotationsregex.dispalyprivatefieldvaluesandcallprivatemethods;

import nl.altindag.log.LogCaptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reflectionannotationsregex.displayprivatefieldsvaluesandcallprivatefieldmethods.ChildClass;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class ChildClassTest {
    private ChildClass childClass;

    @BeforeEach
    void setUp() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        childClass = new ChildClass(12, "123", 'v');
    }

    @Test
    void testCallPrivateVoidCorrectCallingTheMethod() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        LogCaptor logCaptor = LogCaptor.forClass(ChildClass.class);

        childClass.callPrivateVoid();

        assertTrue(logCaptor.getInfoLogs().contains("Hello from void method!"));
    }

    @Test
    void testCallIntMethodCorrectInvokingTheMethod() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        assertEquals(123456789, childClass.callIntMethod());
    }

    @Test
    void testCallStringMethodCorrectInvokingTheMethod() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        assertEquals("Hello from string method!", childClass.callStringMethod());
    }

    @Test
    void testCallCharMethodCorrectInvokingTheMethod() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        assertEquals('v', childClass.callCharMethod());
    }
}
