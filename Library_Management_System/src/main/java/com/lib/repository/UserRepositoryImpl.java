package com.lib.repository;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;

import com.lib.model.User;

/*
 * Implementing the UserRepository Class to do  Database operation
 */
public class UserRepositoryImpl {

	@Autowired
	UserRepository userRepository;

	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	public ArrayList<User> getAllUser() {
		return (ArrayList<User>) userRepository.findAll();
	}


}
