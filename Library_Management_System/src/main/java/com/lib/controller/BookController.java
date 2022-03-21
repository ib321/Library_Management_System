package com.lib.controller;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.lib.exception.BookNotFoundException;
import com.lib.model.Book;
import com.lib.model.User;
import com.lib.repository.UserRepositoryImpl;
import com.lib.service.BookService;
import com.lib.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

	@Autowired
	private BookService bks;

	@Autowired
	private UserService uss;

	public BookController() {
		System.out.println("---Inside cnstrctr BookController---");
	}

	@Autowired
	UserRepositoryImpl usb;

	@PostMapping(path = "/registerUser", consumes = "application/json")
	public void addUser(@RequestBody User user) {
		usb.saveUser(user);
	}

	@GetMapping(path = "/allUserList", produces = "application/json")
	public ArrayList<User> getAllUser() {
		return uss.getAllUser();
	}

	@GetMapping(path = "/validateUser", produces = "application/json")
	public boolean ValidateUser(@RequestParam String name, @RequestParam String password) {
		return uss.validate_User(name, password);
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
	public ModelAndView login(ModelAndView model, HttpServletRequest req, HttpServletResponse res)
			throws ServletException {
		req.logout();
		model.setViewName("Login.jsp");
		return model;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(@RequestParam String name, @RequestParam String password, ModelAndView model)
			throws IOException {

		System.out.println(name + " " + password);

		if (uss.validate_User(name, password)) {
			model.setViewName("home.jsp");
		} else {
			model.addObject("outString",
					"Your UserId Or Password Seems Incorrect :)\n Try Again! \nOr Create New Account :)");
			model.setViewName("Login.jsp");
		}
		return model;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView createuser(@RequestParam String first, @RequestParam String last, @RequestParam String email,
			@RequestParam String address, @RequestParam String userid, @RequestParam Long phone,
			@RequestParam String password, ModelAndView model, HttpServletResponse response, HttpServletRequest request)
			throws IOException {

		User user = new User();
		user.setFirst(first);
		user.setLast(last);
		user.setEmail(email);
		user.setAddress(address);
		user.setUserid(userid);
		user.setPassword(password);
		user.setPhone(phone);
		try {
			usb.saveUser(user);
			model.addObject("outString", "Registered Successfully");
			model.setViewName("Login.jsp");
		} catch (Exception E) {
			model.addObject("outString", "Sorry! Some Error Occured Please Try To Create Your Account Again!:)");
			model.setViewName("Login.jsp");
		}

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
