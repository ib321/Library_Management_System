package com;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookDAO {
     
	public List findByName(String name){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query selectQuery = session.createQuery("select obj from Book obj where obj.name =:ide");
		selectQuery.setParameter("ide", name);
		 List resultset  =  selectQuery.list();
		t.commit();
 		session.close();
		return resultset;
	}
	public List findByAuthor(String author){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query selectQuery = session.createQuery("select obj from Book obj where obj.author =:ide");
		selectQuery.setParameter("ide", author);
		 List resultset  =  selectQuery.list();
		t.commit();
 		session.close();
		return resultset;
	}
	public List findByCategory(String category){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query selectQuery = session.createQuery("select obj from Book obj where obj.category =:ide");
		selectQuery.setParameter("ide", category);
		 List resultset  =  selectQuery.list();
		t.commit();
 		session.close();
		return resultset;
	}
	
	public Book findById(int id){
		Book book=new Book();
		book=null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query selectQuery = (Query) session.createQuery("select obj from Item obj where obj.id =:ide");
		selectQuery.setParameter("ide", id);
		 List resultset  =  selectQuery.list();
		 Book b=new Book();
		for(Object obj: resultset)
        {    
        	 b=(Book) obj;
        }
		t.commit();
 		session.close();
		return b;
	}
	
	
	
	
	
	
}
