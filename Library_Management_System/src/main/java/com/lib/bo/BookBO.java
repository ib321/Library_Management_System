package com.lib.bo;

import java.util.Date;


public class BookBO {

	public boolean checkAvailability(Date returnDate) {
		Date d = new Date();
		int check = d.compareTo(returnDate);
		if (check < 0)
			return false;
		else if (check > 0)
			return true;
		else if (check == 0)
			return false;
		else
			return false;
	}
}
