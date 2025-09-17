package collections.pagebean;

import nl.altindag.log.LogCaptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DistributorTest {
    private Distributor distributor;
    private LogCaptor logCaptor;
    @BeforeEach
    void setUp(){
        List<String> items = new ArrayList<>(List.of("1", "2", "3", "4", "5", "6", "7"));
        distributor = new Distributor(items, 2);
        logCaptor = LogCaptor.forClass(Distributor.class);
    }

    @Test
    void testNextCorrectReturningIfNoNextItemsOrPages(){
        distributor.next();
        distributor.next();
        distributor.next();
        distributor.next();
        distributor.next();

        assertEquals("No next items", logCaptor.getInfoLogs().get(4));
    }

    @Test
    void testNextGoesToTheNextExistingPage() {
        distributor.next();
        distributor.next();
        distributor.previous();
        distributor.next();

        assertEquals("3, 4", logCaptor.getInfoLogs().get(3));
    }

    @Test
    void testNextCreatesNewPage() {
        distributor.next();
        distributor.next();
        distributor.next();
        distributor.next();

        assertEquals("7", logCaptor.getInfoLogs().get(3));
    }

    @Test
    void testNextDeletesTheFirstNElementsAfterEachInvoking() throws NoSuchFieldException, IllegalAccessException {
        distributor.next();
        Field items = distributor.getClass().getDeclaredField("items");
        items.setAccessible(true);

        assertEquals("3, 4, 5, 6, 7", String.join(", ", (List<String>) items.get(distributor)));
    }

    @Test
    void testPreviousThrowsWhenNoPreviousPages(){
        distributor.next();

        assertThrows(IllegalArgumentException.class, () -> distributor.previous());
    }

    @Test
    void testPreviousCorrectReturningThePreviousData(){
        distributor.next();
        distributor.next();
        distributor.previous();

        assertEquals("1, 2", logCaptor.getInfoLogs().get(2));
    }

    @Test
    void testHasNextCorrectReturningIfNoMorePagesButMoreData(){
        distributor.next();
        distributor.next();
        distributor.next();
        distributor.hasNext();

        assertEquals("There are next items to return.", logCaptor.getInfoLogs().get(3));
    }

    @Test
    void testHasNextCorrectReturningIfNoMoreDataButMorePages(){
        distributor.next();
        distributor.next();
        distributor.next();
        distributor.next();
        distributor.previous();
        distributor.hasNext();

        assertEquals("There are next items to return.", logCaptor.getInfoLogs().get(5));
    }

    @Test
    void testHasNextCorrectReturningIfNoMorePagesOrData(){
        distributor.next();
        distributor.next();
        distributor.next();
        distributor.next();
        distributor.hasNext();

        assertEquals("There are no next items to return.", logCaptor.getInfoLogs().get(4));
    }

    @Test
    void testHasPreviousCorrectMessageIfAtFirstPage(){
        distributor.next();
        distributor.hasPrevious();

        assertEquals("There are no previous items", logCaptor.getInfoLogs().get(1));
    }

    @Test
    void testHasPreviousCorrectMessageIfNotAtFirstPage(){
        distributor.next();
        distributor.next();
        distributor.hasPrevious();

        assertEquals("There are previous items", logCaptor.getInfoLogs().get(2));
    }

    @Test
    void testFirstPageCorrectMessageWhenInvoking(){
        distributor.next();
        distributor.next();
        distributor.firstPage();

        assertEquals("1, 2", logCaptor.getInfoLogs().get(2));
    }

    @Test
    void testLastPageCorrectMessageWhenInvoking(){
        distributor.next();
        distributor.next();
        distributor.firstPage();
        distributor.lastPage();

        assertEquals("3, 4", logCaptor.getInfoLogs().get(3));
    }

    @Test
    void testGetCurrPageNumberCorrectMessageWhenInvoking(){
        distributor.next();
        distributor.next();
        distributor.getCurrPageNumber();

        assertEquals("2", logCaptor.getInfoLogs().get(2));
    }
}
