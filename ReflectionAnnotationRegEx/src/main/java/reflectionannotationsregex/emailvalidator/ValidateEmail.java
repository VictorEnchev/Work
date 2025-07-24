package reflectionannotationsregex.emailvalidator;

import java.util.regex.Pattern;

public class ValidateEmail {
    private ValidateEmail(){}

    public static boolean validateEmail(String email){
        String regex = "^[A-Za-z][A-Za-z0-9.-]*@[A-Za-z][A-Za-z0-9.-]*$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(email).find();
    }
}
