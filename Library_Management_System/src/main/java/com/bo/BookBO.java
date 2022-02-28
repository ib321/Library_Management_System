package com.bo;

import java.util.Date;
import java.util.List;

import com.dao.BookDAO;

public class BookBO {
	BookDAO bkd = new BookDAO();

	public List findByName(String name) {
		return bkd.findByName(name);
	}

	public List findByAuthor(String author) {
		return bkd.findByAuthor(author);
	}

	public List findByCategory(String category) {
		return bkd.findByCategory(category);
	}
	
	
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
