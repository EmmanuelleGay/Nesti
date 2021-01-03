package test;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import junit.framework.TestCase;
import toolsControl.HashPassword;

public class ValidHashPassword extends TestCase {
	
	HashPassword validHashPassword = new HashPassword();
	String hashPassword;
	
	
	public void testValidatePassword() throws NoSuchAlgorithmException, InvalidKeySpecException{
		boolean matched;
		
		validHashPassword.generateHashPassword("Azerty34!");
		
		matched = HashPassword.validatePassword("Azerty34!",validHashPassword.getHashPassword());
		assertTrue(matched);
		
		matched = HashPassword.validatePassword("Azerty36!",validHashPassword.getHashPassword());
		assertFalse(matched);
		
		matched = HashPassword.validatePassword("123456",validHashPassword.getHashPassword());
		assertFalse(matched);
		
	}
	
	
}
