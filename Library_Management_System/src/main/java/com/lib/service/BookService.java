package com.lib.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.model.Book;
import com.lib.repository.BookRepositoryImpl;

@Service
public class BookService {
	@Autowired
	private BookRepositoryImpl bkr;

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
	public ArrayList<Book> GetAllBook() {

		ArrayList<Book> ListAll = new ArrayList<Book>();
		try {

			ListAll = bkr.allthebook();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ListAll;
	}
	
	public ArrayList<Book> GetBookByName(String name) {
		ArrayList<Book> nameList = new ArrayList<Book>();
		try {
			nameList = bkr.findByName(name);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return nameList;
	}
	public ArrayList<Book> GetBookByAuthor(String author) {
		ArrayList<Book> authList = new ArrayList<Book>();
		try {
			authList = bkr.findByAuthor(author);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return authList;
	}
	public ArrayList<Book> GetBookByCategory(String category) {
		ArrayList<Book> catList = new ArrayList<Book>();
		try {
			catList = bkr.findByCategory(category);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return catList;
	}
		
}
