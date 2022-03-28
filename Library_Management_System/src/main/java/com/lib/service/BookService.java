package com.lib.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.exception.BookNotFoundException;
import com.lib.model.Book;
import com.lib.repository.BookRepositoryImpl;

/*1. This  class is used for provide some business functionalities 
 * 2.@Service annotates classes at the service layer.
 * 
 */
@Service
public class BookService {
	/*
	 * @Autowired annotation can be used to Auto wire bean just like @Required
	 * annotation.
	 */
	@Autowired
	private BookRepositoryImpl bookRepositoryImpl;

	/*
	 * This method get all book from the database then returns the list of book. if
	 * no any book is available in database then it throws an exception.
	 */
	public ArrayList<Book> getAllBook() {

		ArrayList<Book> ListAll = new ArrayList<Book>();
		try {

			ListAll = bookRepositoryImpl.allBook();
			if (ListAll.isEmpty()) {
				throw new BookNotFoundException("Book Not Found In Database");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ListAll;
	}

	/*
	 * This method searches the database by calling bookRepositoryImpl class for
	 * book by name then returns the list of all the book with that name. if book
	 * with that book name is not available in database then it throws an exception.
	 */

	public ArrayList<Book> getBookByName(String name) {
		ArrayList<Book> nameList = new ArrayList<Book>();
		try {
			nameList = bookRepositoryImpl.findByName(name);
			if (nameList.isEmpty()) {
				throw new BookNotFoundException("Book Not Found In Database");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return nameList;
	}

	/*
	 * This method searches the database by calling bookRepositoryImpl class for
	 * book by author name then returns the list of all the book with that author
	 * name. if book with that author name is not available in database then it
	 * throws an exception.
	 */
	public ArrayList<Book> getBookByAuthor(String author) {
		ArrayList<Book> authList = new ArrayList<Book>();
		try {
			authList = bookRepositoryImpl.findByAuthor(author);
			if (authList.isEmpty()) {
				throw new BookNotFoundException("Book Not Found In Database");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return authList;
	}

	/*
	 * This method searches the database by calling bookRepositoryImpl class for
	 * book by category name then returns the list of all the book with that
	 * category name. if book with that category name is not available in database
	 * then it throws an exception.
	 */
	public ArrayList<Book> getBookByCategory(String category) {
		ArrayList<Book> catList = new ArrayList<Book>();
		try {
			catList = bookRepositoryImpl.findByCategory(category);
			if (catList.isEmpty()) {
				throw new BookNotFoundException("Book Not Found In Database");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return catList;
	}

}