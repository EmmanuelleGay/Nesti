package nesti;

import java.security.SecureRandom;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.SecretKeyFactory;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;


public class HashPassword {
	String hashPassword;
	
/*
	public HashPassword() {
	//	this.hashPassword = hashPassword;
	}
	*/

	/**
	 * Create hash and salt password
	 * @param member
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public void generateHashPassword(String originalPassword) throws NoSuchAlgorithmException, InvalidKeySpecException{
		
	//	String originalPassword;
		String generatedSecuredPasswordHash = generateStorngPasswordHash(originalPassword);
	//	member.setPassword(generatedSecuredPasswordHash);

		setHashPassword(generatedSecuredPasswordHash);
	//	System.out.println("hash password = " + getHashPassword());
	}
	
	/**
	 * 
	 * @param password
	 * @return iterations + ":" + toHex(salt) + ":" + toHex(hash
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	private static String generateStorngPasswordHash(String password)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		int iterations = 1000;
		char[] chars = password.toCharArray();
		byte[] salt = getSalt();

		PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
		SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		byte[] hash = skf.generateSecret(spec).getEncoded();
		return iterations + ":" + toHex(salt) + ":" + toHex(hash);
	}

	/**
	 * Salt password
	 * @return salt
	 * @throws NoSuchAlgorithmException
	 */
	private static byte[] getSalt() throws NoSuchAlgorithmException {
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		byte[] salt = new byte[16];
		sr.nextBytes(salt);
		return salt;
	}

	/**
	 * used to hash password
	 * @param array
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	private static String toHex(byte[] array) throws NoSuchAlgorithmException {
		BigInteger bi = new BigInteger(1, array);
		String hex = bi.toString(16);
		int paddingLength = (array.length * 2) - hex.length();
		if (paddingLength > 0) {
			return String.format("%0" + paddingLength + "d", 0) + hex;
		} else {
			return hex;
		}
	}
	

/**
 * Used to validate the password again when user comes back and login
 * @param originalPassword
 * @param storedPassword
 * @return diff
 * @throws NoSuchAlgorithmException
 * @throws InvalidKeySpecException
 */

    public static boolean validatePassword(String originalPassword, String storedPassword) throws NoSuchAlgorithmException, InvalidKeySpecException
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
    
  /**
   *  used to recover hash password
   * @param hex
   * @return bytes
   * @throws NoSuchAlgorithmException
   */
    private static byte[] fromHex(String hex) throws NoSuchAlgorithmException
    {
        byte[] bytes = new byte[hex.length() / 2];
        for(int i = 0; i<bytes.length ;i++)
        {
            bytes[i] = (byte)Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }
 
    
    /**
	 * @return the hashPassword
	 */
	public String getHashPassword() {
		return hashPassword;
	}

	/**
	 * @param hashPassword the hashPassword to set
	 */
	public void setHashPassword(String hashPassword) {
		this.hashPassword = hashPassword;
	}
	
	
	public String toString() {
		return "hash password : " + this.hashPassword; 
	}
}


	
	
	