package com.Entity;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * Entity Class With Annotation 
 * To Define The Table Structure Of Database 
 * @Ib
 */

@Entity
@Table(name="Book")
public class Book {
	@Id
    private int id;
    private String name;
    private String author;
    private String category;
    @Temporal(TemporalType.DATE)
    private Date returnDate;
    
    public Book(){ }
    
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