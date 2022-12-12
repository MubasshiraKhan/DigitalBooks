package com.digitalbooks.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

 
@Data
public class User
{

	
	private Long id;
	private String username;
	private String email;
	private String password;
	private long phone_no; 
	//private int role_id ;
	private char is_active='Y' ;
	private Set<Role> roles = new HashSet<>();

	/*
	 * @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	 * 
	 * @PrimaryKeyJoinColumn private Book book;
	 */
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}




}