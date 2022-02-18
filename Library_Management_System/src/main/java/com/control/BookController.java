package com.control;



import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Book;
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>This is Not Final Yet!!<br>:)</h1>");
		String name = request.getParameter("book_name");
		if(name!=null)
		out.println("<h1>Hello!!<br> Got it What You Entered as Book Name : <hr>"+name+"<h1>");
		String Author = request.getParameter("author_name");
		if(Author!=null)
		out.println("<h1>Hello!!<br> Got it What You Entered as Author_name : <hr>"+Author+"<h1>");
		String category = request.getParameter("category");
		if(category!=null)
		out.println("<h1>Hello!!<br> Got it What You Entered as category : <hr>"+category+"<h1>");
		bks.DisplayBookByName(name);
		
	}

}
