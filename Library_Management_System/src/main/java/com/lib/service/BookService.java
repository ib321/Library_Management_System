package com.lib.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.model.Book;
import com.lib.repository.BookRepositoryImpl;

@Service
public class BookService {
	@Autowired
	private BookRepositoryImpl bookRepositoryImpl;

	public ArrayList<Book> getAllBook() {

		ArrayList<Book> ListAll = new ArrayList<Book>();
		try {

			ListAll = bookRepositoryImpl.allBook();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ListAll;
	}

	public ArrayList<Book> getBookByName(String name) {
		ArrayList<Book> nameList = new ArrayList<Book>();
		try {
			nameList = bookRepositoryImpl.findByName(name);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return nameList;
	}

	public ArrayList<Book> getBookByAuthor(String author) {
		ArrayList<Book> authList = new ArrayList<Book>();
		try {
			authList = bookRepositoryImpl.findByAuthor(author);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return authList;
	}

	public ArrayList<Book> getBookByCategory(String category) {
		ArrayList<Book> catList = new ArrayList<Book>();
		try {
			catList = bookRepositoryImpl.findByCategory(category);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return catList;
	}

}
