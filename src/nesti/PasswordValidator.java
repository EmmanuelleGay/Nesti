package nesti;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

	private Pattern pattern;
    private Matcher matcher;

    private static final String PASSWORD__PATTERN =
            "^(?=.{8,25}$)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*#?&])(?=.*\\W).*$";

    public PasswordValidator(){
        pattern = Pattern.compile(PASSWORD__PATTERN);
    }

/**
 * Validate password with regular expression
 * @param password
 * @return matcher.matches => true valid password, false invalid password
 */

     public boolean validate(final String password){

        matcher = pattern.matcher(password);
        return matcher.matches();

    }
	
}

