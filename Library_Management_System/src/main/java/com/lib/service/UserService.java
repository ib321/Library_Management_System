package com.lib.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.model.User;
import com.lib.repository.UserRepositoryImpl;

@Service
public class UserService {

	@Autowired
	UserRepositoryImpl userRepositoryImpl;

	public void insertUser(User user) {
		userRepositoryImpl.saveUser(user);
	}

	public ArrayList<User> getAllUser() {
		return (ArrayList<User>) userRepositoryImpl.getAllUser();
	}

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
