package com.digitalbooks.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
 
@Entity
@Table(name = "user")
public class User
{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "user_id")
private int user_id;
private String user_name ;
private String password;
private String email_id ;
private int phone_no; 
private int role_id ;
private char is_active ;
@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
@PrimaryKeyJoinColumn
private Book book;

public Book getBook() {
	return book;
}
public void setBook(Book book) {
	this.book = book;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail_id() {
	return email_id;
}
public void setEmail_id(String email_id) {
	this.email_id = email_id;
}
public int getPhone_no() {
	return phone_no;
}
public void setPhone_no(int phone_no) {
	this.phone_no = phone_no;
}
public int getRole_id() {
	return role_id;
}
public void setRole_id(int role_id) {
	this.role_id = role_id;
}
public char getIs_active() {
	return is_active;
}
public void setIs_active(char is_active) {
	this.is_active = is_active;
}
public User(int user_id, String user_name, String password, String email_id, int phone_no, int role_id,
		char is_active) {
	super();
	this.user_id = user_id;
	this.user_name = user_name;
	this.password = password;
	this.email_id = email_id;
	this.phone_no = phone_no;
	this.role_id = role_id;
	this.is_active = is_active;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}




}