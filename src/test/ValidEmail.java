package test;

import junit.framework.TestCase;
import nesti.EmailValidator;

public class ValidEmail extends TestCase {

	
	public void testPassword() {
		EmailValidator emailValid = new EmailValidator();
		
		assertTrue(emailValid.validate("hello@gmail.com"));
		assertTrue(emailValid.validate("hello@hotmail.fr"));
		assertTrue(emailValid.validate("hello.world@hotmail.fr"));
		assertTrue(emailValid.validate("321@hotmail.fr"));
		
		assertFalse(emailValid.validate("hellogmail.com"));
		assertFalse(emailValid.validate("hello@gmailcom"));
		assertFalse(emailValid.validate("hello@.gmail.com"));
		assertFalse(emailValid.validate("@gmail.com"));
		assertFalse(emailValid.validate("hello@gmail..com"));
		assertFalse(emailValid.validate("hello@gmail.com."));
		assertFalse(emailValid.validate("hello@gmail.m."));
		assertFalse(emailValid.validate("hello@gmail.m"));
		assertFalse(emailValid.validate("hello!you@hotmail.fr"));

	}
}
