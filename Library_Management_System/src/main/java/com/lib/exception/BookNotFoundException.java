package com.lib.exception;

/*
 *BookNotFoundException Exception Class Will be Thrown when book is not found in database
 */
public class BookNotFoundException extends Exception{
   
	private static final long serialVersionUID = 1L;
	public BookNotFoundException(String msg) {
        super(msg);
    }
}
