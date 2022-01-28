package com.aaludra.spring.jpa.h2.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static Date convertStringToDate(String input) {
		DateFormat formatter = new SimpleDateFormat("yyyyMMdd");

		try {
			Date date;
			date = formatter.parse(input);

			return new Date(date.getTime());
		} catch (Exception e) {


			return null;
		}

	}

	public static String convertFloatToString(float input) {
		DecimalFormat formatter = new DecimalFormat("##,###.##");
		return formatter.format(input);
	}

	public static String doubleTocorrency(double value) {
		DecimalFormat df = new DecimalFormat("###,###.##");
		return df.format(value);

	}
}
