package com.string;

import org.apache.commons.lang.StringUtils;

public class BasicString {

	public static void main(String[] args) {
		String str1 = "SAM";
		String str2 = "SAM";
		String longString = "This is a very long long string";
		
		//STRING COMPARISIONS
		System.out.println(str1.equals(str2)+" * "+(str1 == str2));

		str2 = new String("SAM");
		System.out.println(str1.equals(str2)+" * "+(str1 == str2));

		str2 = str1;
		System.out.println(str1.equals(str2)+" * "+(str1 == str2));

		str1 = "RAM";
		System.out.println(str1.equals(str2)+" * "+(str1 == str2));

		str2 = new String(str1);
		System.out.println(str1.equals(str2)+" * "+(str1 == str2));
		
		System.out.println(StringUtils.replace(longString, "long", "short", 1));
		
		String str4 = "$10,223.98";
		str4 = str4.replaceAll("[$|,]", "");
		System.out.println(str4);
		
		//Split function
		String string = "/inmate4inmateList";
		for(int i = 0; i < string.split("/").length; i++){
			System.out.println("Index "+i+" "+string.split("/")[i]);
		}
		
		str4 = "This is a test";
		System.out.println(str4.substring(0, 2000));
	}
}
