package com.lib.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.model.User;
import com.lib.repository.UserRepositoryImpl;

/* This  class is used for provide some business functionalities 
 * @Service annotates classes at the service layer.
 * 
 */
@Service
public class UserService {

	/*
	 * @Autowired annotation can be used to Auto wire bean just like @Required
	 * annotation.
	 */
	@Autowired
	UserRepositoryImpl userRepositoryImpl;

	/*
	 * This method insert user details to the database
	 */
	public String insertUser(User user) {
	
		return userRepositoryImpl.saveUser(user);
	}

	/*
	 * This method get all user from the database then returns the list of user
	 */
	public ArrayList<User> getAllUser() {
		return (ArrayList<User>) userRepositoryImpl.getAllUser();
	}

	/*
	 * This method validate that user id and password given by user is found in the
	 * database then returns the status as true or false
	 */
	public boolean validateUser(String userId, String password) {
		boolean status = false;
		ArrayList<User> users = (ArrayList<User>) userRepositoryImpl.getAllUser();
		for (User user : users) {
			if (user.getUserid().equals(userId) && user.getPassword().equals(password))
				status = true;
		}
		return status;
	}

}
