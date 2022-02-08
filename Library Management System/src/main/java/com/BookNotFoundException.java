package com;

public class BookNotFoundException extends Exception{
	
    public BookNotFoundException(int id) {
        super("Book id not found : " + id);
    }

}
