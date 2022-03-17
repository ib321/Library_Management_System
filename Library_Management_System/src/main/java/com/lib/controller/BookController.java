package com.lib.controller;

import java.io.IOException;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lib.exception.BookNotFoundException;
import com.lib.model.Book;

import com.lib.service.BookService;

@RestController
public class BookController {


	@Autowired
	private BookService bks;


	public BookController() {
		System.out.println("---Inside cnstrctr BookController---");
	}

	@GetMapping(path = "/list", produces = "application/json")
	public ArrayList<Book> getAll() {
		return bks.GetAllBook();

	}

	@GetMapping(path = "/name/{name}", produces = "application/json")
	public ArrayList<Book> SearchName(@PathVariable String name) {
		return bks.GetBookByName(name);
	}

	@GetMapping(path = "/author/{author}", produces = "application/json")
	public ArrayList<Book> SearchAuthor(@PathVariable String author) {
		return bks.GetBookByAuthor(author);
	}

	@GetMapping(path = "/category/{category}", produces = "application/json")
	public ArrayList<Book> Searchcategory(@PathVariable String category) {
		return bks.GetBookByCategory(category);
	}

	@RequestMapping(value = "/login")
	public ModelAndView login(ModelAndView model) {
		model.setViewName("Login.jsp");
		return model;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(@RequestParam String name, @RequestParam String password, ModelAndView model)
			throws IOException {

		System.out.println(name + " " + password);
		// User u=(User)userrepository.findById(name);
		if (name.equals("ib") && password.equals("ib")) {
			model.setViewName("home.jsp");
		} else {
			model.setViewName("Login.jsp");
		}
		return model;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView createuser(HttpServletRequest request, ModelAndView model) throws IOException {
		// we need to work on this function it's not completed
		model.setViewName("Login.jsp");
		return model;
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.GET)
	public ModelAndView Registration(HttpServletRequest request, ModelAndView model) {
		model.setViewName("user.jsp");
		return model;
	}

	@RequestMapping(value = "/showbookbyname", method = RequestMethod.GET)
	public ModelAndView showBookByName(@RequestParam String book_name, HttpServletRequest request, ModelAndView model) {

		try {
			ArrayList<Book> nameList = bks.GetBookByName(book_name);
			model.addObject("listname", nameList);

			if (nameList.isEmpty()) {
				throw new BookNotFoundException("Book Not Found");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		model.setViewName("output.jsp");
		return model;
	}

	@RequestMapping(value = "/showbookbyauthor", method = RequestMethod.GET)
	public ModelAndView showBookByAuthor(@RequestParam String author_name, HttpServletRequest request,
			ModelAndView model) {
		try {
			ArrayList<Book> authList = bks.GetBookByAuthor(author_name);
			model.addObject("listname", authList);
			if (authList.isEmpty()) {

				throw new BookNotFoundException("Book Not Found");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		model.setViewName("output.jsp");
		return model;
	}

	@RequestMapping(value = "/showbookbycategory", method = RequestMethod.GET)
	public ModelAndView showBookByCategory(@RequestParam String category, HttpServletRequest request,
			ModelAndView model) {

		try {
			ArrayList<Book> catList = bks.GetBookByCategory(category);
			model.addObject("listname", catList);
			if (catList.isEmpty()) {

				throw new BookNotFoundException("Book Not Found");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		model.setViewName("output.jsp");
		return model;
	}

}
