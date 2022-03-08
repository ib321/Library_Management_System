package com.lib.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lib.model.Book;
import com.lib.service.BookService;

@Controller
public class BookController {  
	
	public BookController() {
		System.out.println("---Inside cnstrctr BookController---");
	}
   
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "/")
	public ModelAndView login(ModelAndView model) throws IOException {
		model.setViewName("Login");
		return model;
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request,ModelAndView model) throws IOException { 
		String  name= request.getParameter("name");
		String  password= request.getParameter("password");
		System.out.println(name+" "+password);
		if(name.equals("ib")&&password.equals("ib"))
		{
		model.setViewName("home");
		}
		else
		{
			model.setViewName("Login");	
		}
		return model;
	}
	
	@RequestMapping(value = "/showbookbyname", method = RequestMethod.GET)
	public ModelAndView showBookByName(HttpServletRequest request,ModelAndView model) {
		String  name= request.getParameter("book_name");
		List<Book> listBookName = bookService.getBookByName(name);
		model.addObject("listname", listBookName);
		model.setViewName("output");
		return model;
	}
	@RequestMapping(value = "/showbookbyauthor", method = RequestMethod.GET)
	public ModelAndView showBookByAuthor(HttpServletRequest request,ModelAndView model) {
		String  author= request.getParameter("author_name");
		List<Book> listBookAuthor = bookService.getBookByAuthor(author);
		model.addObject("listname", listBookAuthor);
		model.setViewName("output");
		return model;
	}
	@RequestMapping(value = "/showbookbycategory", method = RequestMethod.GET)
	public ModelAndView showBookByCategory(HttpServletRequest request,ModelAndView model) {
		String  category= request.getParameter("category");
		List<Book> listBookCat = bookService.getBookByCategory(category);
		model.addObject("listname", listBookCat);
		model.setViewName("output");
		return model;
	}
	
}
