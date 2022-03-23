package com.lib.controller;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lib.model.Book;
import com.lib.model.User;

import com.lib.service.BookService;
import com.lib.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userService;

	public BookController() {
		System.out.println("---Inside Constructor BookController---");
	}

	@PostMapping(path = "/registerUser", consumes = "application/json")
	public void addUser(@RequestBody User user) {
		userService.InsertUser(user);
	}

	@GetMapping(path = "/allUserList", produces = "application/json")
	public ArrayList<User> getAllUser() {
		return userService.getAllUser();
	}

	@GetMapping(path = "/validateUser", produces = "application/json")
	public boolean validateUser(@RequestParam String name, @RequestParam String password) {
		return userService.validate_User(name, password);
	}

	@GetMapping(path = "/booksList", produces = "application/json")
	public ArrayList<Book> getAll() {
		return bookService.GetAllBook();
	}

	@GetMapping(path = "/name/{name}", produces = "application/json")
	public ArrayList<Book> searchName(@PathVariable String name) {
		return bookService.GetBookByName(name);
	}

	@GetMapping(path = "/author/{author}", produces = "application/json")
	public ArrayList<Book> searchAuthor(@PathVariable String author) {
		return bookService.GetBookByAuthor(author);
	}

	@GetMapping(path = "/category/{category}", produces = "application/json")
	public ArrayList<Book> searchcategory(@PathVariable String category) {
		return bookService.GetBookByCategory(category);
	}

	

}
