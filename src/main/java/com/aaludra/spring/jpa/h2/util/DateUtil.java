package com.aaludra.spring.jpa.h2.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date convertDate(String input) {
		DateFormat formatter = new SimpleDateFormat("yyyyMMdd");

		try {
			Date date;
			date = formatter.parse(input);

			return new Date(date.getTime());
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}

	public static String doubleTocorrency(double value) {
		DecimalFormat df = new DecimalFormat("#,##,##,###.00");
		return df.format(value);
	}
}
