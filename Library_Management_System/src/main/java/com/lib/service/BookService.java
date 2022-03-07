package com.lib.service;

import java.util.List;

import com.lib.model.Book;

public interface BookService {
	public List<Book> getBookByName(String name);

	public List<Book> getBookByAuthor(String author);

	public List<Book> getBookByCategory(String category);
}
