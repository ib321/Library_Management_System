package com.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.List;

import com.entity.Book;
import com.service.BookService;

public class Main {
	 static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		BookDAO bkd=new BookDAO();
		BookService bks=new BookService();
		String print;
		System.out.println("Enter Book:");
		String name=br.readLine();
		//bks.DisplayBookByName(name);
		List l=bkd.findByCategory(name);
		if(l==null) {System.out.println("Not Available"); System.exit(0);}
		System.out.printf("%-15s %-15s %-15s %-15s %s\n","BookNo","BookName","Author","Category","Available");
		for (Object object : l) {
			Book b=(Book) object;
			boolean c=bks.checkAvailability(b.getReturnDate());
			if(c==true) {print="Available";}else {print="Unavailable";}
			System.out.printf("%-15s %-15s %-15s %-15s %s\n",b.getId(),b.getName(),b.getAuthor(),b.getCategory(),print);
		}

	}

}
