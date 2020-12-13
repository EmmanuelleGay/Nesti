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


/*------------------------------jUnit test password validate----------------------

PasswordValidatorTest.java

package com.mkyong.regex;

import org.testng.Assert;
import org.testng.annotations.** ;
 /** **
 **  Password validator Testing
 **  @author mkyong
 **
 ** /public class PasswordValidatorTest {

    private PasswordValidator passwordValidator;

    @BeforeClass
        public void initData(){
        passwordValidator = new PasswordValidator();
        }

    @DataProvider
    public Object[][]ValidPasswordProvider() {
        return new Object[][]{
           {new String[]{
               "mkyong1A@", "mkYOn12$",
           }}
            };
    }

    @DataProvider
    public Object[][]InvalidPasswordProvider() {
        return new Object[][]{
           {new String[]{
               "mY1A@","mkyong12@","mkyoNg12** ",
                            "mkyonG$$","MKYONG12$"
           }}
           };
    }

    @Test(dataProvider = "ValidPasswordProvider")
    public void ValidPasswordTest(String[]password) {

       for(String temp : password){
        boolean valid = passwordValidator.validate(temp);
        System.out.println("Password is valid : " + temp + " , " + valid);
        Assert.assertEquals(true, valid);
       }

    }

    @Test(dataProvider = "InvalidPasswordProvider",
                 dependsOnMethods="ValidPasswordTest")
    public void InValidPasswordTest(String[]password) {

       for(String temp : password){
        boolean valid = passwordValidator.validate(temp);
        System.out.println("Password is valid : " + temp + " , " + valid);
        Assert.assertEquals(false, valid);
       }
    }
}
5. Test unitaire - Résultat
Password is valid : mkyong1A@ , true
Password is valid : mkYOn12$ , true
Password is valid : mY1A@ , false
Password is valid : mkyong12@ , false
Password is valid : mkyoNg12**  , false
Password is valid : mkyonG$$ , false
Password is valid : MKYONG12$ , false
PASSED: ValidPasswordTest([Ljava.lang.String;@1d4c61c)
PASSED: InValidPasswordTest([Ljava.lang.String;@116471f)

*/
