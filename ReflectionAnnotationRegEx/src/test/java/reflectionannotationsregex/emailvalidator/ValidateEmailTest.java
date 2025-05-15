package reflectionannotationsregex.emailvalidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ValidateEmailTest {
    @Test
    void testValidateEmailIfFirstCharIsNotLetter() {
        assertFalse(ValidateEmail.validateEmail("1abc@domain.com"));
    }

    @Test
    void testValidateEmailIfFirstDomainCharIsNotLetter() {
        assertFalse(ValidateEmail.validateEmail("wabc@1omain.com"));
    }

    @Test
    void testValidateEmailIfItIsNotOneAtSign() {
        assertFalse(ValidateEmail.validateEmail("wabc@@domain.com"));
    }

    @Test
    void testValidateEmailIfEverythingIsCorrect() {
        assertTrue(ValidateEmail.validateEmail("wabc@domain.com"));
    }
}
