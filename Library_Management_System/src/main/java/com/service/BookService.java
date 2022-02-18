package com.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.ws.rs.*;

import com.DAO.*;
import com.Entity.Book;

@Path("/bookService")
public class BookService {
	BookDAO bkd = new BookDAO();
	Book b = new Book();

	@GET
	@Path("/displaybook")
	@Produces("text/plain")
	public void DisplayBookByName(String name) throws IOException {
		BookDAO bkd = new BookDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Displaying Book From DataBase :");
		List list = bkd.findByName(name);
		System.out.printf("%-15s %-15s %-15s %-15s %s\n", "Id", "Name", "Author", "Category", "Date");
		for (Object object : list) 
		{
			Book b = (Book) object;
			System.out.printf("%-15s %-15s %-15s %-15s %s\n", b.getId(), b.getName(), b.getAuthor(), b.getCategory(),
					sdf.format(b.getReturnDate()));
		}

	}
}
