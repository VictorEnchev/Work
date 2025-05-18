package reflectionannotationsregex.ibanvalidator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {
    private static final Logger LOG = LoggerFactory.getLogger(Runner.class);
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder result = new StringBuilder(READER.readLine());
        result.append(System.lineSeparator());

        String input = READER.readLine();
        while(!input.equals("</bankAccounts>"))
        {
            result.append(IBANValidator.validateIBAN(input))
                    .append(System.lineSeparator());
            input = READER.readLine();
        }
        result.append(input);

        LOG.info(result.toString());
    }
}
/*
<bankAccounts>
<iban>GR16 0110 1050 0000 1054 7023 795</iban>
<iban>GB35 MIBG 4025 3432 1446 70</iban>
<iban>SA80 8000 0375 6080 1019 0160</iban>
<iban>CH51 0868 6001 2565 1500 1</iban>
<iban>BG80 BNBG 9661 1020 3456 7840</iban>
<iban>IL30 01BG 0300 0009 6339 234</iban>
<iban>AL47 2121 1009 0000 0002 3569 8741</iban>
<iban>AZ21 NABZ 0000 0000 1370 1000 1944</iban>
<iban>BG80 BNBG 9661 1020 3456 7843</iban>
</bankAccounts>
 */