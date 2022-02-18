package com.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.List;

import com.entity.Book;

public class Main {
	 static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		BookDAO bkd=new BookDAO();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Enter Book:");
		String name=br.readLine();
		List l=bkd.findByName(name);
		System.out.printf("%-15s %-15s %-15s %-15s %s\n","Id","Name","Author","Category","Date");
		for (Object object : l) {
			Book b=(Book) object;
			System.out.printf("%-15s %-15s %-15s %-15s %s\n",b.getId(),b.getName(),b.getAuthor(),b.getCategory(),sdf.format(b.getReturnDate()));
		}

	}

}
