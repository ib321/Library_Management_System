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
	 * Rest API method for User Operation
	 * Register user, All user, Validate User 
	 */
	@PostMapping(path = "/registerUser", consumes = "application/json")
	public void addUser(@RequestBody User user) {
		userService.insertUser(user);
	}

	@GetMapping(path = "/allUserList", produces = "application/json")
	public ArrayList<User> getAllUser() {
		return userService.getAllUser();
	}

	@GetMapping(path = "/validateUser/{name}/{password}", produces = "text/html")
	public boolean validateUser(@PathVariable String name, @PathVariable String password) {
		return userService.validateUser(name, password);
	}
	
	/* Rest API method for Book Operation
	 * All the book list, Book List Using Name
	 * Book list Using Category And book List Using Author 
	 */

	@GetMapping(path = "/booksList", produces = "application/json")
	public ArrayList<Book> getAllBook() {
		return bookService.getAllBook();
	}

	@GetMapping(path = "/name/{name}", produces = "application/json")
	public ArrayList<Book> searchByName(@PathVariable String name) {
		return bookService.getBookByName(name);
	}

	@GetMapping(path = "/author/{author}", produces = "application/json")
	public ArrayList<Book> searchByAuthor(@PathVariable String author) {
		return bookService.getBookByAuthor(author);
	}

	@GetMapping(path = "/category/{category}", produces = "application/json")
	public ArrayList<Book> searchByCategory(@PathVariable String category) {
		return bookService.getBookByCategory(category);
	}

	

}
