package com.http.client;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class ClientExample {
	private static final String URL_1 = "https://www.hillsborough.realforeclose.com/index.cfm?zaction=AUCTION&zmethod=PREVIEW&AuctionDate=2013-06-19";
	private static final String URL_2 = "https://www.hillsborough.realforeclose.com/index.cfm?zaction=AUCTION&Zmethod=UPDATE&FNC=LOAD&AREA=C&PageDir=0&doR=1";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HttpClient client = new DefaultHttpClient();
		try {
			printResponse(client, URL_1);
			printResponse(client, URL_2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void printResponse(HttpClient client, String url) throws Exception {
	    HttpGet request = new HttpGet(url);
	    HttpResponse response = client.execute(request);
	    System.out.println(response.getStatusLine().getStatusCode());
	    //BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	    System.out.println(EntityUtils.toString(response.getEntity()));
	}
}
