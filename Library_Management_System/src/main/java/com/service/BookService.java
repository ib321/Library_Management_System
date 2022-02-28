package com.service;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.bo.BookBO;

@Path("/bookService")
public class BookService {
	

	@GET
	@Path("/displaybookbyname")
	@Produces("JSON/Application")
	public List getBookByName(String name) {
		BookBO bkb = new BookBO();
		List listbook = bkb.findByName(name);
		return listbook; 
	}
	
	@GET
	@Path("/displaybookbyauthor")
	@Produces("JSON/Application")
	public List getBookByAuthor(String author) {
		BookBO bkb = new BookBO();
		List listbook = bkb.findByAuthor(author);
		return listbook; 
		}
	
	@GET
	@Path("/displaybookcategory")
	@Produces("JSON/Application")
	public List getBookByCategory(String category) {
		BookBO bkb = new BookBO();
		List listbook = bkb.findByCategory(category);
		return listbook; 
		}
	

	
	
}
