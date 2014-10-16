package com.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;

public class FileCLient {

	public static void main(String[] args) throws Exception {
		//File InputStrean (READ from file - SOURCE OF DATA)
		int ch;
		StringBuffer strContent = new StringBuffer("");
		FileInputStream iStream = new FileInputStream("notes.txt");
		while((ch = iStream.read()) != -1){
			strContent.append((char)ch);
		}
		System.out.print(strContent);
		iStream.close();
		
		//File Output Stream (WRITE to file - DESTINATION OF DATA)
		FileOutputStream oStream = new FileOutputStream("test_file.txt");
		String str = "Test File";
		oStream.write(str.getBytes());
		oStream.close();

		//Read file contents to String
		BufferedReader reader = new BufferedReader(new FileReader("notes.txt"));
		String line  = null;
		StringBuilder stringBuilder = new StringBuilder();
		String ls = System.getProperty("line.separator");
		while((line = reader.readLine()) != null ) {
		    stringBuilder.append(line);
		    stringBuilder.append(ls);
		}
		System.out.println("#######");
		System.out.println(stringBuilder.toString());
		System.out.println("#######");
	}
}
