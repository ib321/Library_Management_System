package com.ib.lms.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ib.lms.model.User;
import com.ib.lms.repository.UserRepositoryService;

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
	UserRepositoryService userRepositoryService;

	/*
	 * This method insert user details to the database
	 */
	public String insertUser(User user) {
	
		return userRepositoryService.saveUser(user);
	}

	/*
	 * This method get all user from the database then returns the list of user
	 */
	public ArrayList<User> getAllUser() {
		return (ArrayList<User>) userRepositoryService.getAllUser();
	}

	/*
	 * This method validate that user id and password given by user is found in the
	 * database then returns the status as true or false
	 */
	public boolean validateUser(String userId, String password) {
		boolean status = false;
		ArrayList<User> users = (ArrayList<User>) userRepositoryService.getAllUser();
		for (User user : users) {
			if (user.getUserid().equals(userId) && user.getPassword().equals(password))
				status = true;
		}
		return status;
	}

}
