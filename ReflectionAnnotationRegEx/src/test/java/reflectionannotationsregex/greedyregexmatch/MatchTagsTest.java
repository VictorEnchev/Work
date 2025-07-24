package reflectionannotationsregex.greedyregexmatch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchTagsTest {
    @Test
    void testMatchXTagCorrectMatching() {
        String input = "<x><b></b><x>Hello world</x>\n" +
                "<b>sdfsdf</b><x>Good morning</x><x>69</x><x>sdfsdfsd</x>\n" +
                "</x>";

        String expected = "<x><b></b><x/>\n" +
                "<b>sdfsdf</b><x/><x/><x/>\n" +
                "</x>";

        assertEquals(expected, MatchTags.matchXTag(input));
    }
}
