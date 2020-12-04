package nesti;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

	private Pattern pattern;
    private Matcher matcher;

    private static final String PASSWORD__PATTERN =
            "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,25}$";

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


/*
 * 
 * 
 * Next step is to have a function which can be used to validate the password again when user comes back and login.

public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException 
    {
        String  originalPassword = "password";
        String generatedSecuredPasswordHash = generateStorngPasswordHash(originalPassword);
        System.out.println(generatedSecuredPasswordHash);
         
        boolean matched = validatePassword("password", generatedSecuredPasswordHash);
        System.out.println(matched);
         
        matched = validatePassword("password1", generatedSecuredPasswordHash);
        System.out.println(matched);
    }
     
    private static boolean validatePassword(String originalPassword, String storedPassword) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        String[] parts = storedPassword.split(":");
        int iterations = Integer.parseInt(parts[0]);
        byte[] salt = fromHex(parts[1]);
        byte[] hash = fromHex(parts[2]);
         
        PBEKeySpec spec = new PBEKeySpec(originalPassword.toCharArray(), salt, iterations, hash.length * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] testHash = skf.generateSecret(spec).getEncoded();
         
        int diff = hash.length ^ testHash.length;
        for(int i = 0; i < hash.length && i < testHash.length; i++)
        {
            diff |= hash[i] ^ testHash[i];
        }
        return diff == 0;
    }
    private static byte[] fromHex(String hex) throws NoSuchAlgorithmException
    {
        byte[] bytes = new byte[hex.length() / 2];
        for(int i = 0; i<bytes.length ;i++)
        {
            bytes[i] = (byte)Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }
 */



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
