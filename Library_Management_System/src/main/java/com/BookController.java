package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookController")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookController() {
        super();
    }
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
    	
    	 BookDAO bkd=new BookDAO();
		PrintWriter out=response.getWriter();
		      out.println("<h1>This is an example</h1>");
		      String name=request.getParameter("book_name");
		      List list=bkd.findByName(name);
		    	//System.out.printf("%-15s %-15s %-15s %-15s %s\n","id","Name","Author","Category","Available");
		    	for (Object object : list) {
		    		Book book=(Book)object;
		    		out.println("<h1>Hiii</h1><br>"+book.getName()+"   "+book.getAuthor());
		    		//System.out.printf("%-15s %-15s %-15s %-15s %s\n",book.getId(),book.getName(),book.getAuthor(),book.getCategory(),"Later");
				}
		}
		
	}



