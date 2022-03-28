package com.lib.repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.lib.model.Book;

/*
 * Implementing the BookRepository Class to do All the Database operation
 */
public class BookRepositoryImpl {

	@Autowired
	private BookRepository bookRepository;

	/*
	 * Get all the books from database and Returns List of all book
	 */
	public ArrayList<Book> allBook() {
		ArrayList<Book> ListAll = (ArrayList<Book>) bookRepository.findAll();
		return ListAll;
	}

	/*
	 * Get all the books with input name from database and Returns List of books
	 * with same name
	 */
	public ArrayList<Book> findByName(String name) {

		ArrayList<Book> ListAll = (ArrayList<Book>) bookRepository.findAll();
		ArrayList<Book> nameList = new ArrayList<Book>();
		for (Book book : ListAll) {
			if (book.getName().equalsIgnoreCase(name))
				nameList.add(book);
		}
		return nameList;
	}
    
	/*
	 * Get all the books with input author name from database and Returns List of books
	 * with same author name
	 */
	public ArrayList<Book> findByAuthor(String author) {
		ArrayList<Book> ListAll = (ArrayList<Book>) bookRepository.findAll();
		ArrayList<Book> authList = new ArrayList<Book>();
		for (Book book : ListAll) {
			if (book.getAuthor().equalsIgnoreCase(author))
				authList.add(book);
		}
		return authList;
	}
	/*
	 * Get all the books with input category from database and Returns List of books
	 * with same category
	 */
	public ArrayList<Book> findByCategory(String category) {
		ArrayList<Book> ListAll = (ArrayList<Book>) bookRepository.findAll();
		ArrayList<Book> catList = new ArrayList<Book>();
		for (Book book : ListAll) {
			if (book.getCategory().equalsIgnoreCase(category))
				catList.add(book);
		}
		return catList;
	}

}
