package com.lib.bo;

import java.util.Date;


public class BookBO {

	public static String checkAvailability(Date returnDate) {
		Date d = new Date();
		int check = d.compareTo(returnDate);
		if (check < 0)
			return "Unavailable";
		else if (check > 0)
			return "Available";
		else if (check == 0)
			return "Unavailable";
		else
			return "Unavailable";
	
	}
}
