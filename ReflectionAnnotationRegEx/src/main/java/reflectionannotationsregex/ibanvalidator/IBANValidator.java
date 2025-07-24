package reflectionannotationsregex.ibanvalidator;

import java.util.regex.Pattern;

/**
 * Contains a method for validating an IBAN code
 */
public class IBANValidator {
    /**
     * Validates an IBAN code whether it is bulgarian or not. If it is bulgarian, the code is being replaced by ****
     * @param input IBAN code
     * @return checked IBAN code
     */
    public static String validateIBAN(String input)
    {
        String regex = "(?<=<iban>)(BG\\d{2}\\s?[A-Z]{4}(?:\\s?\\d{4}){3}\\s?\\d{4})(?=<\\/iban>)";
        Pattern patter = Pattern.compile(regex);

        StringBuilder result = new StringBuilder();
        if(patter.matcher(input).find())
        {
            return result.append(input, 0, 6)
                    .append("****")
                    .append(input, input.length() - 7, input.length())
                    .toString();
        }
        else return input;
    }
}
