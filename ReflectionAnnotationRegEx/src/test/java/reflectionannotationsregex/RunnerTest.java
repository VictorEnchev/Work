package reflectionannotationsregex;

import nl.altindag.log.LogCaptor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reflectionannotationsregex.displayclassinformation.RandomClass;
import reflectionannotationsregex.displayclassinformation.Runner;

import static org.junit.jupiter.api.Assertions.*;

public class RunnerTest {
    @Test
    void testPrintMethodsInformationCorrectLogging(){
        LogCaptor logCaptor = LogCaptor.forClass(Runner.class);
        RandomClass rc = new RandomClass(3, 4, 5);

        Runner.printMethodsInformation(rc);

        assertTrue(logCaptor.getInfoLogs().contains("protectedVoidMethod: int int int "));
        assertTrue(logCaptor.getInfoLogs().contains("privateIntMethod: int int "));
        assertTrue(logCaptor.getInfoLogs().contains("publicVoidMethod: int "));
    }

    @Test
    void testPrintFieldsInformationCorrectLogging(){
        LogCaptor logCaptor = LogCaptor.forClass(Runner.class);
        RandomClass rc = new RandomClass(3, 4, 5);

        Runner.printFieldsInformation(rc);

        assertTrue(logCaptor.getInfoLogs().contains("privateField; int; 3"));
        assertTrue(logCaptor.getInfoLogs().contains("publicField; int; 4"));
        assertTrue(logCaptor.getInfoLogs().contains("protectedField; int; 5"));
    }
}
