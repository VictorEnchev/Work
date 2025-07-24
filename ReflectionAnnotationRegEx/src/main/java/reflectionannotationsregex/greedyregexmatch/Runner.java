package reflectionannotationsregex.greedyregexmatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner {
    private static final Logger LOG = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {
        String input = "<x><b></b><x>Hello world</x>\n" +
                "<b>sdfsdf</b><x>Good morning</x><x>69</x><x>sdfsdfsd</x>\n" +
                "</x>";

        LOG.info(MatchTags.matchXTag(input));
    }
}
