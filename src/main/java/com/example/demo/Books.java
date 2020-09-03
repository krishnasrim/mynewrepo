package com.example.demo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;  
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;  
//mark class as an Entity ADDED  
@Entity  
//defining class name as Table name  
@Table(name="books") 
public class Books  implements Serializable
{  
//Defining book id as primary key  
@Id  
@GeneratedValue(strategy = GenerationType.AUTO)
private int bookid;  
public Books(int bookid, @NotNull @Size(min = 5, message = "Name should have at least 5 characters") String bookname,
		@NotBlank(message = "author is mandatory") String author, int price) {
	super();
	this.bookid = bookid;
	this.bookname = bookname;
	this.author = author;
	this.price = price;
}
@Column 
@NotNull

@Size(min=5,message="Name should have at least 5 characters")
private String bookname;  
@Column  
@NotBlank(message = "author is mandatory")

private String author;  
@Column  
private int price;

@OneToMany(mappedBy = "books", fetch = FetchType.LAZY,
cascade = CascadeType.ALL)
private Set<SqlTable> sqlTable;


@Override
public String toString() {
	return "Books [bookid=" + bookid + ", bookname=" + bookname + ", author=" + author + ", price=" + price
			+ ", sqlTable=" + sqlTable + "]";
}










public Set<SqlTable> getSqlTable() {
	return sqlTable;
}










public void setSqlTable(Set<SqlTable> sqlTable) {
	this.sqlTable = sqlTable;
}










public int getBookid() {
	return bookid;
}










public Books() {
	super();
	// TODO Auto-generated constructor stub
}

public void setBookid(int bookid) {
	this.bookid = bookid;
}
public String getBookname() {
	return bookname;
}
public void setBookname(String bookname) {
	this.bookname = bookname;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}  
}