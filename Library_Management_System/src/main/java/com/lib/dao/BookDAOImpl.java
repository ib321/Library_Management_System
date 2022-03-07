package com.lib.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lib.model.Book;


@Repository
public class BookDAOImpl implements BookDAO{ 
	@Autowired
	private SessionFactory sessionFactory; 
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		Query selectQuery = session.createQuery("select obj from Book obj where obj.name =:au");
		selectQuery.setParameter("au", name);
		List<Book> resultset = selectQuery.list();
		return resultset;
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<Book>  findByAuthor(String author) {
		Session session = sessionFactory.getCurrentSession();
		Query selectQuery = session.createQuery("select obj from Book obj where obj.author =:au");
		selectQuery.setParameter("au", author);
		List<Book> resultset = selectQuery.list();
		return resultset;
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<Book>  findByCategory(String category) {
		Session session = sessionFactory.getCurrentSession();
		Query selectQuery = session.createQuery("select obj from Book obj where obj.category =:cat");
		selectQuery.setParameter("cat", category);
		List<Book> resultset = selectQuery.list();
		return resultset;
	}

}
