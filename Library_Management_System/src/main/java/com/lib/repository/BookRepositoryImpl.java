package com.lib.repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.lib.model.Book;

public class BookRepositoryImpl {
	
	@Autowired
	private BookRepository repository;


	public ArrayList<Book> allthebook() {
		ArrayList<Book> ListAll = (ArrayList<Book>) repository.findAll();
		return ListAll;
	}

	public ArrayList<Book> findByName(String name) {

		ArrayList<Book> ListAll = (ArrayList<Book>) repository.findAll();
		ArrayList<Book> nameList = new ArrayList<Book>();
		for (Book book : ListAll) {
			if (book.getName().equalsIgnoreCase(name))
				nameList.add(book);
		}
		return nameList;
	}


	public ArrayList<Book> findByAuthor(String author) {
		ArrayList<Book> ListAll = (ArrayList<Book>) repository.findAll();
		ArrayList<Book> authList = new ArrayList<Book>();
		for (Book book : ListAll) {
			if (book.getAuthor().equalsIgnoreCase(author))
				authList.add(book);
		}
		return authList;
	}


	public ArrayList<Book> findByCategory(String category) {
		ArrayList<Book> ListAll = (ArrayList<Book>) repository.findAll();
		ArrayList<Book> catList = new ArrayList<Book>();
		for (Book book : ListAll) {
			if (book.getCategory().equalsIgnoreCase(category))
				catList.add(book);
		}
		return catList;
	}


}
