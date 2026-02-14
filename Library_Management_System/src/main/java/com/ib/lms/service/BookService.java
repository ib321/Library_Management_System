package com.ib.lms.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ib.lms.exception.BookNotFoundException;
import com.ib.lms.model.Book;
import com.ib.lms.repository.BookRepositoryService;

/*1. This  class is used for provide some business functionalities 
 * 2.@Service annotates classes at the service layer.
 * 
 */
@Service
public class BookService {
    private static final Logger log = LoggerFactory.getLogger(BookService.class);
    /*
	 * @Autowired annotation can be used to Auto wire bean just like @Required
	 * annotation.
	 */
	@Autowired
	private BookRepositoryService bookRepositoryService;

	public String insertBook(Book book) {

		return bookRepositoryService.saveBook(book);
	}

	public String editBook(Book book) {

		return bookRepositoryService.editBook(book);
	}

	/*
	 * This method get all book from the database then returns the list of book. if
	 * no any book is available in database then it throws an exception.
	 */
	public ArrayList<Book> getAllBook() {

		ArrayList<Book> ListAll = new ArrayList<Book>();
		try {

			ListAll = bookRepositoryService.allBook();
			if (ListAll.isEmpty()) {
				throw new BookNotFoundException("Book Not Found In Database");
			}

		} catch (Exception e) {
			log.error("exception occurred in bookservice:", e);
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
			nameList = bookRepositoryService.findByName(name);
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
			authList = bookRepositoryService.findByAuthor(author);
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
			catList = bookRepositoryService.findByCategory(category);
			if (catList.isEmpty()) {
				throw new BookNotFoundException("Book Not Found In Database");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return catList;
	}

}