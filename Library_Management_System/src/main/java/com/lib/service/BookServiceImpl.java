package com.lib.service;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lib.dao.BookDAO;
import com.lib.model.Book;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO bkd;

	@Override
	@Transactional
	public List<Book> getBookByName(String name) {

		return bkd.findByName(name);
	}

	@Override
	@Transactional
	public List<Book> getBookByAuthor(String author) {

		return bkd.findByAuthor(author);
	}

	@Override
	@Transactional
	public List<Book> getBookByCategory(String category) {

		return bkd.findByCategory(category);
	}

}
