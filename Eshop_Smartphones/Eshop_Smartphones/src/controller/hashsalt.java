package controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
 

public class hashsalt {
	public String hashpassword(String password) throws NoSuchAlgorithmException {
		
		
		String data=password;
		String algorithm = "MD5";
		
		 
		
		byte[] salt=createSalt();
		 
		 
		
		return generateHash(data,algorithm,salt);
		
	}
	private static String generateHash(String data,String algorithm,byte[] salt)throws NoSuchAlgorithmException {
		MessageDigest digest=MessageDigest.getInstance(algorithm);
		digest.reset();
		digest.update(salt);
		byte[] hash=digest.digest(data.getBytes());
		return bytesToStringHex(hash);
		
	}
	private final static  char[] hexArray="0123456789ABCDEF".toCharArray();
	
	public static String bytesToStringHex(byte[] bytes) {
		char[] hexChars=new char[bytes.length*2];
		for (int j=0;j<bytes.length;j++) {
			int v =bytes[j] & 0xFF;
			hexChars[j * 2]=hexArray[v>>>4];
			hexChars[j*2+1]=hexArray[v&0x0f];
			
		}
		return new String(hexChars);
	}
	public static byte[] createSalt() {
		byte[] bytes =new byte[20];
		//SecureRandom random=new SecureRandom();
		//random.nextBytes(bytes);
		String mystring="todikomou";
		bytes=mystring.getBytes();
		
		return bytes;
	}
}
