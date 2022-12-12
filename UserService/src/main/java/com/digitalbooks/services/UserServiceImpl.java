package com.digitalbooks.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbooks.models.User;
import com.digitalbooks.repository.UserRepository;

@Service
public class UserServiceImpl {

	@Autowired
	UserRepository repo;
	
	public List<User> getAllUsers() 
	{
	List<User> users = new ArrayList<User>();
	repo.findAll().forEach(user -> users.add(user));
	return users;
	}
	
	public User getUsersById(long id) 
	{
	return repo.findById(id).get();
	}

}
