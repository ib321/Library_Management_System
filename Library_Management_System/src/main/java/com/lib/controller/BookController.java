package com.lib.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lib.model.Book;
import com.lib.model.User;

import com.lib.service.BookService;
import com.lib.service.UserService;

/*
 * Rest Controller Class For All the Rest API operation
 * All the Methods are mapped for Different operations
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userService;

	public BookController() {
	}

	/*
	 * Rest API method for User Operation This method insert the details of user in
	 * database by calling userService class and it is using Rest API operation
	 */
	@PostMapping(path = "/registerUser", consumes = "application/json")
	public String addUser(@RequestBody User user) {
		return userService.insertUser(user);
	}

	/*
	 * Rest API method for User Operation This method gets the details of user from
	 * database by calling userService class and it is using Rest API operation and
	 * it will return all the list of users
	 */
	@GetMapping(path = "/allUserList", produces = "application/json")
	public ArrayList<User> getAllUser() {
		return userService.getAllUser();
	}

	/*
	 * This method validate username and password given by user against user details
	 * available in database if it gets both Correct then return true otherwise
	 * false
	 */
	@GetMapping(path = "/validateUser/{name}/{password}", produces = "text/html")
	public boolean validateUser(@PathVariable String name, @PathVariable String password) {
		return userService.validateUser(name, password);
	}

	@PostMapping(path = "/addBook", consumes = "application/json")
	public String addBook(@RequestBody Book book) {
		System.out.println(book.getId());
		return bookService.insertBook(book);
	}

	@PostMapping(path = "/editBook", consumes = "application/json")
	public String editBook(@RequestBody Book book) {
		System.out.println(book.getName());
		return bookService.editBook(book);
	}

	/*
	 * This method gets the all books from database by calling bookService class.
	 * and using Rest API operation it will return list of all the books
	 */
	@GetMapping(path = "/booksList", produces = "application/json")
	public ArrayList<Book> getAllBook() {
		return bookService.getAllBook();
	}

	/*
	 * This method searches the database for book against given name by calling
	 * bookService class. using Rest API operation it will then returns the list of
	 * book with the same name
	 */
	@GetMapping(path = "/name/{name}", produces = "application/json")
	public ArrayList<Book> searchByName(@PathVariable String name) {
		return bookService.getBookByName(name);
	}

	/*
	 * This method searches the database for book against given author name by
	 * calling bookService class. using Rest API operation it will then returns the
	 * list of book with the same author name
	 */
	@GetMapping(path = "/author/{author}", produces = "application/json")
	public ArrayList<Book> searchByAuthor(@PathVariable String author) {
		return bookService.getBookByAuthor(author);
	}

	/*
	 * This method searches the database for book against given category name by
	 * calling bookService class. using Rest API operation it will then returns the
	 * list of book with the same category name
	 */
	@GetMapping(path = "/category/{category}", produces = "application/json")
	public ArrayList<Book> searchByCategory(@PathVariable String category) {
		return bookService.getBookByCategory(category);
	}

}
