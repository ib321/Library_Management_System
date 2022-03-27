package com.lib.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.exception.BookNotFoundException;
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
			if(ListAll.isEmpty())
			{
				throw new BookNotFoundException("Book Not Found In Database");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ListAll;
	}

	public ArrayList<Book> getBookByName(String name) {
		ArrayList<Book> nameList = new ArrayList<Book>();
		try {
			nameList = bookRepositoryImpl.findByName(name);
			if(nameList.isEmpty())
			{
				throw new BookNotFoundException("Book Not Found In Database");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return nameList;
	}

	public ArrayList<Book> getBookByAuthor(String author) {
		ArrayList<Book> authList = new ArrayList<Book>();
		try {
			authList = bookRepositoryImpl.findByAuthor(author);
			if(authList.isEmpty())
			{
				throw new BookNotFoundException("Book Not Found In Database");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return authList;
	}

	public ArrayList<Book> getBookByCategory(String category) {
		ArrayList<Book> catList = new ArrayList<Book>();
		try {
			catList = bookRepositoryImpl.findByCategory(category);
			if(catList.isEmpty())
			{
				throw new BookNotFoundException("Book Not Found In Database");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return catList;
	}

}
