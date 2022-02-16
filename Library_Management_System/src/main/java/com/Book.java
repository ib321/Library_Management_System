package com;
import java.util.Date;

public class Book {
    private int id;
    private String name;
    private String author;
    private String category;
    private Date returnDate;
    
    public Book(){}
    
    public Book(int id,String name, String author, String category, Date returnDate){
        this.id=id;
        this.name=name;
        this.author=author;
        this.category=category;
        this.returnDate=returnDate;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

}