package reflectionannotationsregex.greedyregexmatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Contains a method for matching strings by given tags
 */
public class MatchTags {
    /**
     * Replaces a string between tag <x> an </x> with <x/>
     * @param input Random string
     * @return modified string
     */
    public static String matchXTag(String input) {
        String regEx = "<x>.[^<x>]*?</x>";
        Pattern pattern = Pattern.compile(regEx, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(input);

        return matcher.replaceAll("<x/>");
    }
}
