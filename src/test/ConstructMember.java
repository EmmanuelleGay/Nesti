package test;

import junit.framework.TestCase;
import nesti.Member;

public class ConstructMember extends TestCase {

	String lastName = "Bond";
	String firstName = "James";
	String alias = "007";
	String email = "james@bond.com";
	String town = "London";
	String password = "James007!";	
	
	public void testConstructor() {
			
		Member member = new Member(lastName,firstName,alias,email,town,password);
		
		assertEquals(lastName, member.getLastName());
		assertEquals(firstName, member.getFirstName());
		assertEquals(alias, member.getAlias());
		assertEquals(email, member.getEmail());
		assertEquals(town, member.getTown());
		assertEquals(password, member.getPassword());
		
	}
	
}
