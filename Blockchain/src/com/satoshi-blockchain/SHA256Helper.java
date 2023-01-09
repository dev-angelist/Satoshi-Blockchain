package com.globalsoftwaresupport;

import java.security.MessageDigest;

public class SHA256Helper {

	public static String generateHash(String data) {
		try {		
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(data.getBytes("UTF-8"));

			//we want to end up with hexadecimal values not bytes
			StringBuilder hexadecimalString = new StringBuilder();
		
			for (int i = 0; i < hash.length; i++) {
				String hexadecimal = Integer.toHexString(0xff & hash[i]);
				// padding !!!
				if(hexadecimal.length() == 1) hexadecimalString.append('0');
				hexadecimalString.append(hexadecimal);
			}
			
			return hexadecimalString.toString();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
