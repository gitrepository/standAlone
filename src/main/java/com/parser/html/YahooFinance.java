package com.parser.html;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class YahooFinance {
	//http://finance.yahoo.com/q?s=GS
	private static final String SUMMARY = "http://finance.yahoo.com/q";
	
	//http://finance.yahoo.com/q/pr?s=GS+Profile
	private static final String PROFILE = "http://finance.yahoo.com/q/pr";

	//http://finance.yahoo.com/q/co?s=F+Competitors
	private static final String COMPETITORS = "http://finance.yahoo.com/q/co";

	//http://finance.yahoo.com/q/hp?s=GS+Historical+Prices
	private static final String HISTORIC_PRICE = "http://finance.yahoo.com/q/hp";

	
	public static void main(String[] args) {
		
		try {
			//#1
			Document doc = Jsoup.connect(SUMMARY+"?s=NUO-C").timeout(1000 * 1000).get();
			if(!doc.select("head title").first().text().equalsIgnoreCase("Symbol Lookup from Yahoo! Finance")){
		        Element content = doc.select("div#yfi_related_tickers").first();
		        Element el1 = content.select(":containsOwn(People viewing)").first();
		        Elements results = el1.select("a[href]");
	        	System.out.println("PEOPLE VIEWED \n");
		        for (Element result : results) {
		        	System.out.println(result.text());
		        }

		        System.out.println();
		        System.out.println();
			}

	        //#2
			doc = Jsoup.connect(PROFILE+"?s=GS"+"+Profile").get();//.timeout(1000 * 1000).get();
        	
	        Elements els = doc.select("table.yfnc_datamodoutline1");
	        for (Element el : els) {
	        	Element el2 = el.select(":containsOwn(Sector)").first();
	        	if(el2 != null){

		        	System.out.println("SECTOR: "+el2.nextElementSibling().text());
		        	el2 = el.select(":containsOwn(Industry)").first();
		        	if(el2 != null){
		        		System.out.println("INDUSTRY: "+el2.nextElementSibling().text());
		        	}
	        		break;
	        	}
	        }
	        
	        els = doc.select("div.yfi_rt_quote_summary");
	        
	        for (Element el : els) {
	        	Element el2 = el.select("div.title").first();
	        	String st = el2.getAllElements().get(0).text();
	        	Element el3 = el2.select("span.rtq_exch").first();
	        	st = el3.getAllElements().get(0).text();
	        	if(el2 != null){

		        	System.out.println("SECTOR: "+el2.nextElementSibling().text());
		        	el2 = el.select(":containsOwn(Industry)").first();
		        	if(el2 != null){
		        		System.out.println("INDUSTRY: "+el2.nextElementSibling().text());
		        	}
	        		break;
	        	}
	        }
	        
	        
        	Elements els3 = doc.select("p");
        	for(Element el2 : els3){
        		Element el3 = el2.previousElementSibling();
        		if(el3 != null){
	        		Element test = el3.select(":matchesOwn(Business Summary)").first();
	        		if(test != null){
		        		System.out.println(el2.text());
	        		} else {
		        		System.out.println("N");
	        		}
        		}
        	}
        	

	        /*
	        //SUMMARY (TODO)
	        els = doc.select(":containsOwn(Business Summary)");
	        for (Element el : els) {
	        	Element el2 = el.select(":containsOwn(Business Summary)").first();
	        	if(el2 != null){
	        		Element el3 = el.child(el2.siblingIndex()+1);
	        		System.out.println("Business Summary: "+el3.text());
	        		break;
	        	}
	        }
	        */
	        
	        System.out.println();
	        System.out.println();

	        //#3
			doc = Jsoup.connect(COMPETITORS+"?s=GS"+"+Competitors").get();//.timeout(1000 * 1000).get();
	        els = doc.select("table.yfnc_mod_table_title1");
	        for (Element el : els) {
	        	Element el2 = el.select(":containsOwn(Direct Competitor Comparison)").first();
	        	if(el2 != null){
	        		el2 = el2.parent();
	        		el2 = el2.parent();
	        		el2 = el2.parent().siblingElements().first();
	        		Elements els2 = el2.select("a[href]");
	        		System.out.println("Competitors are: ");
	    	        for (Element el3 : els2) {
    	        		System.out.println(el3.text());
	    	        }
	        		break;
	        	}
	        }

	        
	        //#4
			doc = Jsoup.connect(HISTORIC_PRICE+"?s=GS"+"+Historical+Prices").get();//.timeout(1000 * 1000).get();
	        Element el = doc.select(":containsOwn(Start Date)").first();
    		el = el.parent().parent().parent().parent();
    		Element el2 = el.select("option[selected]").first();
    		System.out.println("MM: "+el2.val());
    		el2 = el.select("input").get(0);
    		System.out.println("DD: "+el2.val());
    		el2 = el.select("input").get(1);
    		System.out.println("YYYY: "+el2.val());

	        
	        System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
