package reflectionannotationsregex.emailvalidator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner {
    private static final Logger LOG = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {
        if(ValidateEmail.validateEmail("test.t-s@sir-ma.com ")) LOG.info("This email is valid");
        else LOG.info("This email is not valid");
    }
}
