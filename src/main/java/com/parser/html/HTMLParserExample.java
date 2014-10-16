package com.parser.html;
import java.io.File;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLParserExample {
    public static void main(String[] args) {
    	try{
    		//test();
    		String searchStr = "First Name";
    		
    		File input = new File("parse.html");
            Document doc = Jsoup.parse(input, "UTF-8");

            Elements text = doc.select(":containsOwn("+searchStr+")");
            Iterator<Element> itr = text.iterator();
	        while(itr.hasNext()){
	        	Element p = ((Element) itr.next()).parent();
	        	Elements c = p.children();
	        	System.out.println(searchStr+" = "+c.get(1).text());
	        }

	        searchStr = "Zip";
	        System.out.println(searchStr+" = "+getSearchValue(doc, searchStr));

    	}catch (Exception e){
    		e.printStackTrace();
    	}
    }
    
    public static String getSearchValue(Document doc, String searchStr){
        String result = "";
        Elements text1 = doc.select(":containsOwn("+searchStr+")");
        Iterator<Element> itr = text1.iterator();
        while(itr.hasNext()){
        	Element p = ((Element) itr.next()).parent().parent();
        	Element c = p.children().get(0);
        	Elements cs = c.children();
            Iterator itr1 = cs.iterator();
            int indx = 0;
	        while(itr1.hasNext()){
	        	String txt = ((Element) itr1.next()).text();
	        	if(txt.equals(searchStr))
	        		break;
	        	++indx;
	        }

        	c = p.children().get(1);
        	Element cx = c.children().get(indx);
        	result = cx.text();
        }
    	return result;
    }
    
    private void test(){
    	try{
            Document doc = Jsoup.connect("http://www.developer.nokia.com/Devices/Device_specifications/Nokia_Asha_308/").timeout(1000 * 1000).get();
            Elements content = doc.select("div.accordeonContainer");
            for (Element spec : content) {
                Elements h2 = spec.select("h2.accordeonTitle");
                System.out.println(h2.text());

                Elements dl = spec.select("dl.clearfix");
                Elements dts = dl.select("dt");
                Elements dds = dl.select("dd");

                Iterator<Element> dtsIterator = dts.iterator();
                Iterator<Element> ddsIterator = dds.iterator();
                while (dtsIterator.hasNext() && ddsIterator.hasNext()) {
                    Element dt = (Element) dtsIterator.next();
                    Element dd = (Element) ddsIterator.next();
                    System.out.println("\t\t" + dt.text() + "\t\t" + dd.text());
                }
            }
	    }catch (Exception e){
    		e.printStackTrace();
    	}
    }
}
