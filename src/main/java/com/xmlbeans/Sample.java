package com.xmlbeans;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.xmlbeans.XmlOptions;
import org.example.address.AddressDetailsDocument;
import org.example.address.AddressDetailsDocument.AddressDetails;

public class Sample {
	public static void main(String[] args) {
		try {
			//Marshaling
			//Set data to Java object created with reference to XML Schema
			AddressDetailsDocument doc = AddressDetailsDocument.Factory.newInstance();
			AddressDetails details = doc.addNewAddressDetails();
			details.setAddress1("123 main street");
			details.setEmail("qaz@wsx.com");
			details.setZIP("30350");
	
			System.out.println("Marshalling");
			System.out.println(doc.toString());
			System.out.println();
			
			//UnMarshaling
			//XML to Java (UnMarshaling)
			AddressDetailsDocument myParsedDoc;
			AddressDetails myParsedDetails;
	
			System.out.println("Marshalling");
			myParsedDoc = AddressDetailsDocument.Factory.parse(fileToString("src\\main\\java\\com\\xmlbeans\\address01.xml"));
			myParsedDetails = myParsedDoc.getAddressDetails();
			System.out.println("File #1 - valid "+myParsedDetails.validate()+" * "+myParsedDetails.getName()+" * "+myParsedDetails.getEmail());
			
			myParsedDoc = AddressDetailsDocument.Factory.parse(fileToString("src\\main\\java\\com\\xmlbeans\\address02.xml"));
			myParsedDetails = myParsedDoc.getAddressDetails();
			System.out.println("File #2 - valid "+myParsedDetails.validate()+" * "+myParsedDetails.getName()+" * "+myParsedDetails.getEmail());
			//Validation
			validateAddress(fileToString("src\\main\\java\\com\\xmlbeans\\address02.xml"));
			System.out.println();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void validateAddress(String xmlString){
		// Set up the validation error listener.
		ArrayList validationErrors = new ArrayList();
		XmlOptions validationOptions = new XmlOptions();
		validationOptions.setErrorListener(validationErrors);

		try{
			AddressDetailsDocument myDoc = AddressDetailsDocument.Factory.parse(xmlString);
			boolean isValid = myDoc.validate(validationOptions);
			// Print the errors if the XML is invalid.
			if (!isValid) {
			    Iterator iter = validationErrors.iterator();
			    while (iter.hasNext()){
			        System.out.println(">> " + iter.next() + "\n");
			    }
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public static String fileToString(String filePath){
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			String line  = null;
			StringBuilder stringBuilder = new StringBuilder();
			String ls = System.getProperty("line.separator");
			while((line = reader.readLine()) != null ) {
			    stringBuilder.append(line);
			    stringBuilder.append(ls);
			}
			return stringBuilder.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
