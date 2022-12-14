package com.digitalbooks.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
 
@Entity
@Table(name = "books")
public class Book
{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "book_id")
private int book_id;
@NotBlank
@Size(max = 20)
private String book_title ;
@NotBlank
@Size(max = 3)
private String book_code;

@NotBlank
private String author_name;
@Positive(message = "Only Positive Values")
private int price;
private String category;
private String publisher;
@NotBlank
private String logopath;
@Lob
private byte[] logo;
private String content ;
private Boolean isActive; 
 
private Date updated_on; 
private int created_by;
@NotBlank
private Date created_on;
	/*
	 * @OneToOne
	 * 
	 * @MapsId
	 * 
	 * @JoinColumn(name = "user_id") private User user;
	 */



public String getAuthor_name() {
	return author_name;
}


public void setAuthor_name(String author_name) {
	this.author_name = author_name;
}


public Date getUpdated_on() {
	return updated_on;
}


public void setUpdated_on(Date updated_on) {
	this.updated_on = updated_on;
}


public Date getCreated_on() {
	return created_on;
}


public void setCreated_on(Date created_on) {
	this.created_on = created_on;
}


public int getBook_id() {
	return book_id;
}


public void setBook_id(int book_id) {
	this.book_id = book_id;
}


public String getBook_title() {
	return book_title;
}


public void setBook_title(String book_title) {
	this.book_title = book_title;
}


public String getBook_code() {
	return book_code;
}


public void setBook_code(String book_code) {
	this.book_code = book_code;
}



public int getPrice() {
	return price;
}


public void setPrice(int price) {
	this.price = price;
}


public String getCategory() {
	return category;
}


public void setCategory(String category) {
	this.category = category;
}


public String getPublisher() {
	return publisher;
}


public void setPublisher(String publisher) {
	this.publisher = publisher;
}


public byte[] getLogo() {
	return logo;
}


public void setLogo(byte[] logo) {
	this.logo = logo;
}


public String getContent() {
	return content;
}


public void setContent(String content) {
	this.content = content;
}

public int getCreated_by() {
	return created_by;
}


public void setCreated_by(int created_by) {
	this.created_by = created_by;
}



public Book(int book_id, String book_title, String book_code, String author_name, int price, String category,
		String publisher, byte[] logo, String content,Boolean is_active, Date updated_on, int created_by,
		Date created_on) {
	super();
	this.book_id = book_id;
	this.book_title = book_title;
	this.book_code = book_code;
	this.author_name = author_name;
	this.price = price;
	this.category = category;
	this.publisher = publisher;
	this.logo = logo;
	this.content = content;
	this.isActive = is_active;
	this.updated_on = updated_on;
	this.created_by = created_by;
	this.created_on = created_on;
}


public Book() {
	super();
	// TODO Auto-generated constructor stub
}


public String getLogopath() {
	return logopath;
}


public void setLogopath(String logopath) {
	this.logopath = logopath;
}


public Boolean getIsActive() {
	return isActive;
}


public void setIsActive(Boolean isActive) {
	this.isActive = isActive;
}








}