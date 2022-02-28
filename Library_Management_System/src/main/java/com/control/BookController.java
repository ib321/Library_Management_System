package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.BookBO;
import com.entity.Book;
import com.exception.BookNotFoundException;
import com.service.BookService;

@WebServlet("/BookController")
public class BookController extends HttpServlet { 
	
	private static final long serialVersionUID = 1L;

	public BookController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BookService bks = new BookService();
		BookBO bkb = new BookBO();
		String print;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println(
				"<html> <head> <style>h1{color: #0ae312;}"
				+ "table,th,td{ width: 40%; background-color: #e3520a; border: 1px solid black; }"
						
				+ "</style> <link rel=\"stylesheet\" type=\"text/css\" href=\"input1.css\"></head>");
		out.println("<body><center><h1 style=\"color:white;\">This is Not Final Yet!!:)</h1> ");
		List l = new ArrayList();
		String name = request.getParameter("book_name");
		if (name != null) {
			l = bks.getBookByName(name);
			out.println("<h1>Hello!! Got it What You Entered  <br> Book Name :" + name + "</h1>");
		}
		String Author = request.getParameter("author_name");
		if (Author != null) {
			l = bks.getBookByAuthor(Author);
			out.println("<h1>Hello!! Got it What You Entered <br>Author Name :" + Author + "</h1>");
		}
		String category = request.getParameter("category");
		if (category != null) {
			l = bks.getBookByCategory(category);
			out.println("<h1>Hello!! Got it What You Entered <br>Category:<hr>" + category + "</h1>");
		}

		try {
			if (l.isEmpty()) {
				out.println("<h1 style=\\\"color:white;\\>Not Available<h1><hr>");
				throw new BookNotFoundException("Book Not Found in Database");
			} 
			else 
			{
				out.println("<h2 style=\"color:white;\">Book Details</h2>");
				out.printf(
						"<table ><tr><th>BookNo</th><th>BookName</th> <th>Author</th> <th>Category</th><th>Available</th></tr></table>");

				for (Object object : l) { 
					
					Book b = (Book) object;
					
					boolean c = bkb.checkAvailability(b.getReturnDate());
					if (c == true)
						print = "Available";
					else
						print = "Unavailable";

					
					out.println("<center><table><tr><td>" + b.getId() + "</td><td>" + b.getName() + "</td><td>"
							+ b.getAuthor() + "</td><td>" + b.getCategory() + "</td><td>" + print
							+ "</td></tr></table></center>");
				}
			}
		} catch (Exception e) {
			out.println(e);
		}
		out.println("</body></html>");

	}

}

//out.printf("%-15s %-15s %-15s %-15s %s<br>", "BookNo", "BookName", "Author", "Category", "Available");
//out.printf("%-25s %-25s %-25s %-25s %s<br>", b.getId(), b.getName(), b.getAuthor(), b.getCategory(),print);
