package com.lib.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lib.model.Book;
import com.lib.repository.BookRepository;

public class BookDAOImpl implements BookDAO {

	@Autowired
	private BookRepository repository;

	@Override
	public ArrayList<Book> findByName(String name) {

		ArrayList<Book> ListAll = (ArrayList<Book>) repository.findAll();
		ArrayList<Book> nameList = new ArrayList<Book>();
		for (Book book : ListAll) {
			if (book.getName().equalsIgnoreCase(name))
				nameList.add(book);
		}
		return nameList;
	}

	@Override
	public ArrayList<Book> findByAuthor(String author) {
		ArrayList<Book> ListAll = (ArrayList<Book>) repository.findAll();
		ArrayList<Book> authList = new ArrayList<Book>();
		for (Book book : ListAll) {
			if (book.getAuthor().equalsIgnoreCase(author))
				authList.add(book);
		}
		return authList;
	}

	@Override
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
