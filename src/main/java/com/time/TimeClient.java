package com.time;

import java.util.Date;

public class TimeClient {

	public static void main(String[] args) {
		Date dt = new Date();
		System.out.println(dt.getTime());
		dt = new Date(new Long("1371502261003"));
		System.out.println(dt);
		dt = new Date(new Long("1371602816430"));
		System.out.println(dt);
	}

}
