package com.xslt;

import java.io.FileOutputStream;
import java.util.Calendar;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XmlToHtml {
	public static void main(String[] args) {
		try {
			Calendar c1 = Calendar.getInstance();
			TransformerFactory tFactory = TransformerFactory.newInstance();

			Transformer transformer = tFactory.newTransformer(new StreamSource("src\\main\\java\\com\\xslt\\rapsheet.xsl"));
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer
				.transform(new javax.xml.transform.stream.StreamSource("src\\main\\java\\com\\xslt\\rapsheet.xml"),
						new StreamResult(new FileOutputStream("src\\main\\java\\com\\xslt\\rapsheet.html")
						)
				);
			Calendar c2 = Calendar.getInstance();
			System.out.println("Transformation completed in : "+(c2.getTimeInMillis()-c1.getTimeInMillis())+" ms");
		}
		catch (Exception e) {
			e.printStackTrace( );
		}
	}
}
