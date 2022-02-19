package com.service;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.*;

import com.dao.BookDAO;
import com.entity.Book;

@Path("/bookService")
public class BookService {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	@GET
	@Path("/displaybook")
	@Produces("text/plain")
	public List getBookByName(String name) throws IOException {
		BookDAO bkd = new BookDAO();
		BookService bks = new BookService();
		String print;
		List l = bkd.findByName(name);
		return l; 
		}

		/*
		 * if (l.isEmpty()) { System.out.println("Not Available"); System.exit(0); }
		 * System.out.printf("%-15s %-15s %-15s %-15s %s\n", "BookNo", "BookName",
		 * "Author", "Category", "Available"); for (Object object : l) { Book b = (Book)
		 * object; boolean c = bks.checkAvailability(b.getReturnDate()); if (c ==
		 * true)print = "Available"; else print = "Unavailable";
		 * 
		 * System.out.printf("%-15s %-15s %-15s %-15s %s\n", b.getId(), b.getName(),
		 * b.getAuthor(), b.getCategory(), print); }
		 * 
		 * }
		 */
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
