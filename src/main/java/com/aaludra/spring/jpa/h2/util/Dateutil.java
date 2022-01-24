package com.aaludra.spring.jpa.h2.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dateutil {
	public static Date convertStringToDate(String input) {
		
		
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		
		try {
			java.util.Date date;
			date = formatter.parse(input);
			return new Date(date.getTime());
			
		} catch (ParseException e) {

			e.printStackTrace();
			return null;
		}
		
	}
}
		
		
		
		
		
		
		
		
		
		