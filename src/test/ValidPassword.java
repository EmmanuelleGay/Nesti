package test;

import junit.framework.TestCase;
import nesti.PasswordValidator;

public class ValidPassword extends TestCase {

	
	public void testPassword() {
		
		  PasswordValidator password = new PasswordValidator();
	
		  assertTrue(password.validate("Azerty34!"));
		  assertTrue(password.validate("123!!!?Bb"));
		  assertTrue(password.validate("@?aayBB3"));
		  assertTrue(password.validate("123!!!?Bb"));
		  assertTrue(password.validate("babarC123456?"));
		  
		  assertFalse(password.validate("123456789"));
		  assertFalse(password.validate("abcdefghij"));
		  assertFalse(password.validate("abcdef123456"));
		  assertFalse(password.validate("ABCDEFGH"));
		  assertFalse(password.validate("aabbbCCC11111"));
		  assertFalse(password.validate("1aA?"));
		  assertFalse(password.validate("123456AAAA!??"));
		  assertFalse(password.validate("?!!!!@123a"));
		  assertFalse(password.validate("?!!!!@123aaaaaaaBBBBBBBBBabbbbbbbbbba"));
		
	}
}
