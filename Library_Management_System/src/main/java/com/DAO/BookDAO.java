package com.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Book;

public class BookDAO {

	public List findByName(String name) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query selectQuery = session.createQuery("select obj from Book obj where obj.name =:au");
		selectQuery.setParameter("au", name);
		List resultset = selectQuery.list();
		session.close();
		return resultset;
	}

	public List findByAuthor(String author) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query selectQuery = session.createQuery("select obj from Book obj where obj.author =:au");
		selectQuery.setParameter("au", author);
		List resultset = selectQuery.list();
		session.close();
		return resultset;
	}

	public List findByCategory(String category) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query selectQuery = session.createQuery("select obj from Book obj where obj.category =:cat");
		selectQuery.setParameter("cat", category);
		List resultset = selectQuery.list();
		session.close();
		return resultset;
	}

}
