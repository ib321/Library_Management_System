package com.lib.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lib.dao.BookDAO;
import com.lib.dao.BookDAOImpl;
import com.lib.model.Book;
import com.lib.model.User;
import com.lib.repository.BookRepository;
import com.lib.repository.UserRepository;

@RestController
public class BookController {

	@Autowired
	private BookRepository repository;

	@Autowired
	private UserRepository userrepository;

	public BookController() {
		System.out.println("---Inside cnstrctr BookController---");
	}

	@GetMapping(path = "/list", produces = "application/json")
	public ArrayList<Book> getData() {
		ArrayList<Book> ListAll = (ArrayList<Book>) repository.findAll();
		return ListAll;
	}

	@GetMapping(path = "/name/{name}", produces = "application/json")
	public ArrayList<Book> SearchName(@PathVariable String name) {
		ArrayList<Book> ListAll = (ArrayList<Book>) repository.findAll();
		ArrayList<Book> nameList = new ArrayList<Book>();
		for (Book book : ListAll) {
			if (book.getName().equalsIgnoreCase(name))
				nameList.add(book);
		}
		return nameList;
	}

	@GetMapping(path = "/author/{author}", produces = "application/json")
	public ArrayList<Book> SearchAuthor(@PathVariable String author) {
		ArrayList<Book> ListAll = (ArrayList<Book>) repository.findAll();
		ArrayList<Book> authList = new ArrayList<Book>();
		for (Book book : ListAll) {
			if (book.getAuthor().equalsIgnoreCase(author))
				authList.add(book);
		}
		return authList;

	}

	@GetMapping(path = "/category/{category}", produces = "application/json")
	public ArrayList<Book> Searchcategory(@PathVariable String category) {
		ArrayList<Book> ListAll = (ArrayList<Book>) repository.findAll();
		ArrayList<Book> catList = new ArrayList<Book>();
		for (Book book : ListAll) {
			if (book.getCategory().equalsIgnoreCase(category))
				catList.add(book);
		}
		return catList;

	}

	@RequestMapping(value = "/login")
	public ModelAndView login(ModelAndView model) {
		model.setViewName("Login.jsp");
		return model;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request, ModelAndView model) throws IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
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

		model.setViewName("Login.jsp");

		return model;
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.GET)
	public ModelAndView Registration(HttpServletRequest request, ModelAndView model) {
		model.setViewName("user.jsp");
		return model;
	}

	@RequestMapping(value = "/showbookbyname", method = RequestMethod.GET)
	public ModelAndView showBookByName(HttpServletRequest request, ModelAndView model) {
		String name = request.getParameter("book_name");
		ArrayList<Book> ListAll = (ArrayList<Book>) repository.findAll();
		ArrayList<Book> nameList = new ArrayList<Book>();
		for (Book book : ListAll) {
			if (book.getName().equalsIgnoreCase(name))
				nameList.add(book);
		}
		model.addObject("listname", nameList);
		model.setViewName("output.jsp");
		return model;
	}

	@RequestMapping(value = "/showbookbyauthor", method = RequestMethod.GET)
	public ModelAndView showBookByAuthor(HttpServletRequest request, ModelAndView model) {
		String author = request.getParameter("author_name");
		ArrayList<Book> ListAll = (ArrayList<Book>) repository.findAll();
		ArrayList<Book> authList = new ArrayList<Book>();
		for (Book book : ListAll) {
			if (book.getAuthor().equalsIgnoreCase(author))
				authList.add(book);
		}

		model.addObject("listname", authList);
		model.setViewName("output.jsp");
		return model;
	}

	@RequestMapping(value = "/showbookbycategory", method = RequestMethod.GET)
	public ModelAndView showBookByCategory(HttpServletRequest request, ModelAndView model) {
		String category = request.getParameter("category");
		ArrayList<Book> ListAll = (ArrayList<Book>) repository.findAll();
		ArrayList<Book> catList = new ArrayList<Book>();
		for (Book book : ListAll) {
			if (book.getCategory().equalsIgnoreCase(category))
				catList.add(book);
		}
		model.addObject("listname", catList);
		model.setViewName("output.jsp");
		return model;
	}

}
