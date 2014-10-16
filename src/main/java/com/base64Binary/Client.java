package com.base64Binary;

import java.io.FileInputStream;

import org.apache.commons.codec.binary.Base64;

public class Client {

	public static void main(String[] args) throws Exception {
		String str = "This is a test";
		
		FileInputStream iStream = new FileInputStream("generateNotificationReport.pdf");
//		IOUtils.toByteArray(iStream);
//		
//		byte[] bytes = Base64.encodeBase64();
//		
//		String str1 = new String(bytes, "UTF-8");
//		System.out.println(str1);
	}

}
