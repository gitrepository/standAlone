package com.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateExp {
	public static void main(String[] args) {
		try{
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			
			dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_MONTH, -1);
			System.out.println(dateFormat.format(cal.getTime()));
			
			System.out.println(new java.sql.Date(date.getTime())+" * "+new java.sql.Time(date.getTime()));
			System.out.println(new java.sql.Timestamp(date.getTime()));
			System.out.println(new Date());
			
			cal.add(Calendar.DAY_OF_MONTH, -30);
			System.out.println(dateFormat.format(cal.getTime()));
			
			String dateString1 = "Aug 9, 2012";
			date = new SimpleDateFormat("MMM dd, yyyy").parse(dateString1);
			String dateString2 = new SimpleDateFormat("MM/dd/yyyy").format(date);
			System.out.println(dateString2); // 2011-04-16
			
			System.out.println(new SimpleDateFormat("MM/dd/yyyy").parse("1/1/2013"));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
