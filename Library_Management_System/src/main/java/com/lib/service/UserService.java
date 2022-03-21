package com.lib.service;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.model.User;
import com.lib.repository.UserRepositoryImpl;
@Service
public class UserService {

	@Autowired
	UserRepositoryImpl usempl;

	public void InsertUser(User user) {
		usempl.saveUser(user);
	}
	
	public ArrayList<User> getAllUser() {
		return (ArrayList<User>) usempl.getAllUser();
	}
	
	public boolean validate_User(String userId,String Password)
	{  boolean status=false;
		ArrayList<User> users=(ArrayList<User>) usempl.getAllUser();
		for (User user : users) {
			if(user.getUserid().equals(userId)&&user.getPassword().equals(Password))
				status=true;
		}
		return status;
	}


}
