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
	public ModelAndView listEmployee(ModelAndView model) throws IOException {
		
		model.setViewName("home");
		return model;
	}
	
	@RequestMapping(value = "/showbookbyname", method = RequestMethod.GET)
	public ModelAndView showBookByName(HttpServletRequest request,ModelAndView model) {
		String  name= request.getParameter("bookname");
		List<Book> listBookName = bookService.getBookByName("wonder");
		model.addObject("listname", listBookName);
		model.setViewName("output");
		return model;
	}
	@RequestMapping(value = "/showbookbyauthor", method = RequestMethod.GET)
	public ModelAndView showBookByAuthor(HttpServletRequest request,ModelAndView model) {
		String  author= request.getParameter("bookauthor");
		List<Book> listBookAuthor = bookService.getBookByAuthor(author);
		model.addObject("listname", listBookAuthor);
		model.setViewName("output");
		return model;
	}
	@RequestMapping(value = "/showbookbycategory", method = RequestMethod.GET)
	public ModelAndView showBookByCategory(HttpServletRequest request,ModelAndView model) {
		String  category= request.getParameter("bookcategory");
		List<Book> listBookCat = bookService.getBookByCategory(category);
		model.addObject("listname", listBookCat);
		model.setViewName("output");
		return model;
	}
	
}
