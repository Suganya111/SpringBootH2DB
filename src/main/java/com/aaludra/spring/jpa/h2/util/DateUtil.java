package com.aaludra.spring.jpa.h2.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateUtil {
	public static Timestamp convertStringToTimestamp(String input) {
		DateFormat formatter = new SimpleDateFormat("yyyy-dd-mm");

		try {
			java.util.Date date;
			date = formatter.parse(input);

			return new Timestamp(date.getTime());
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}
}
