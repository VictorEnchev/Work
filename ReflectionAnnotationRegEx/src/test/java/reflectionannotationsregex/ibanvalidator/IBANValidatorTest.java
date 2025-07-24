package reflectionannotationsregex.ibanvalidator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IBANValidatorTest {
    @Test
    void testValidateIBANCorrectValidating()
    {
        assertEquals("<iban>****</iban>",IBANValidator.validateIBAN("<iban>BG12 BNBG 1234 5678 9012 3456</iban>"));
    }

    @Test
    void testValidateIBANCorrectValidatingWithNoSpaces()
    {
        assertEquals("<iban>****</iban>",IBANValidator.validateIBAN("<iban>BG12BNBG1234567890123456</iban>"));
    }

    @Test
    void testValidateIBANCorrectValidatingWithIncorrectInput()
    {
        assertEquals("<iban>GB12 BNBG 1234 5678 9012 3456</iban>",IBANValidator.validateIBAN("<iban>GB12 BNBG 1234 5678 9012 3456</iban>"));
    }
}
