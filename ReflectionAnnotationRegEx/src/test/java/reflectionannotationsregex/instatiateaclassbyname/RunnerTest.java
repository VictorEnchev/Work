package reflectionannotationsregex.instatiateaclassbyname;

import nl.altindag.log.LogCaptor;
import org.junit.jupiter.api.Test;
import reflectionannotationsregex.instantiateaclassbyname.Runner;
import reflectionannotationsregex.instantiateaclassbyname.SomeClass;

import static org.junit.jupiter.api.Assertions.*;

class RunnerTest {
    @Test
    void testPrintInterfaceNameCorrectPrinting() {
        LogCaptor logCaptor = LogCaptor.forClass(Runner.class);
        SomeClass someClass = new SomeClass(4);

        Runner.printInterfaceName(someClass);

        assertTrue(logCaptor.getInfoLogs().contains("Name of interface 1: SomeInterface"));
    }

    @Test
    void testPrintClassNameCorrectPrinting() {
        LogCaptor logCaptor = LogCaptor.forClass(Runner.class);
        SomeClass someClass = new SomeClass(4);

        Runner.printClassName(someClass);

        assertTrue(logCaptor.getInfoLogs().contains("Name of the parent class: SomeClass"));
    }

}
