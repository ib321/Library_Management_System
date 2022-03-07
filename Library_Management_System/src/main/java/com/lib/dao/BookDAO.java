package com.lib.dao;

import java.util.List;

import com.lib.model.Book;

public interface BookDAO {

	public List<Book> findByName(String name);

	public List<Book> findByAuthor(String author);

	public List<Book> findByCategory(String category);
}
