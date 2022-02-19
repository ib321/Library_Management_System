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

import com.dao.BookDAO;
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
        BookService bks=new BookService();
        BookDAO bkd = new BookDAO();
        String print,search = null;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>This is Not Final Yet!!<br>:)</h1>");
		List l=new ArrayList();
		List ch=new ArrayList();
		String name = request.getParameter("book_name");
		if(name!=null) {
			search = name;
			 l = bks.getBookByName(search);
		out.println("<h1>Hello!!<br> Got it What You Entered <br> Book Name : <hr>"+name+"<h1>");
		            }
		String Author = request.getParameter("author_name");
		if(Author!=null)
		{ search=Author;
		 l = bkd.findByAuthor(search);
		out.println("<h1>Hello!!<br> Got it What You Entered <br> Author_name : <hr>"+Author+"<h1>");
		}
		String category = request.getParameter("category");
		if(category!=null)
		{    l = bkd.findByCategory(search);
			search=category;
		out.println("<h1>Hello!!<br> Got it What You Entered <br> category : <hr>"+category+"<h1>");
		}
		
			
			
			
			try {
			if (l.isEmpty()) {
				out.println("<h1>Not Available<h1><hr>");
				throw new BookNotFoundException("Book Not Found in Database");
			}
			else {
				out.println("<h2 align=\"middle\">Book Details</h2>");
			    out.printf("%-15s %-15s %-15s %-15s %s<br>", "BookNo", "BookName", "Author", "Category", "Available");
				for (Object object : l) {
					Book b = (Book) object;
					boolean c = bks.checkAvailability(b.getReturnDate());
					if (c == true)print = "Available";
				    else print = "Unavailable";
			    //out.println("<h3>"+ b.getId()+b.getName()+b.getAuthor()+b.getCategory()+print+"<h3>");
			    out.printf("%-25s %-25s %-25s %-25s %s<br>", b.getId(), b.getName(), b.getAuthor(), b.getCategory(),print);
					}}
			}
			catch(Exception e)
			{
				out.println(e);
			}
			

		}
		
	}


