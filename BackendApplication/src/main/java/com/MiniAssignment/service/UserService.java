package com.MiniAssignment.service;

import com.MiniAssignment.model.User;

public interface UserService {
	
	//register new user by saving details
	public void saveUser(User user);
	
	//to check whether user with the email already exists
	public boolean fetchUserByEmailId(String email);
	
	//to check if the user with given email and password exists
	public boolean fetchUserByEmailIdAndPassword(String email, String pass);
}
