package com.thread;

import java.util.Date;

public class Thread01Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//With Threading
		Date st = new Date();
		methodWithOut();
		Date en = new Date();
		System.out.println("### I - "+(en.getTime()-st.getTime()));
		
		st = new Date();
		methodWith();
		en = new Date();
		System.out.println("### II -"+(en.getTime()-st.getTime()));
	}
	
	public static void methodWith(){
		int count = 0;
		char startUpper = 'A';
		for (int i = 0; i < 26; i++) {
			count++;
	        new Thread01(""+startUpper++).start();
		}
		System.out.println("I "+count);
	}
	
	public static void methodWithOut(){
		int count = 0;
		char startUpper = 'A';
		for (int i = 0; i < 26; i++) {
			char chr = 'A';
			for (int j = 0; j < 26; j++) {
				count++;
				startUpper++;
				chr++;
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("II "+count);
	}
}
