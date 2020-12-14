package test;

import junit.framework.TestCase;
import nesti.DalQuery;
import nesti.MyConnexion;

public class TestQuery extends TestCase {

	public void testCreateSingleMember() {
		
	
	try {
		MyConnexion.openConnection();
	
	}
		 catch (Exception e) {
				System.err.println("Erreur d'insertion du membre: " + e.getMessage());
			}
		 
}
}