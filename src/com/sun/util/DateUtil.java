package com.sun.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date fromStringToDate(String dateStr) {
		//String time = "2019-07-23";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date dateTime = null;
		 try {
			 dateTime = simpleDateFormat.parse(dateStr);
		 } catch (ParseException e) {
			 e.printStackTrace();
		 }
		 
	 return dateTime;
	}
	public static void main(String[] args) {
		String dateStr = "2020-06-09 122:12:12";
		System.out.println(fromStringToDate(dateStr));
	}
}
