package com.lib.repository;

import com.lib.model.Book;


import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
