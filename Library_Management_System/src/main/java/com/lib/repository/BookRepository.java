package com.lib.repository;

import com.lib.model.Book;


import org.springframework.data.repository.CrudRepository;


/*
 * BookRepository interface extends the CrudRepository it will connect to the database
 */
public interface BookRepository extends CrudRepository<Book, Integer> {

}
