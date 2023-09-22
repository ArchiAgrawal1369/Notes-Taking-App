package com.MiniAssignment.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.MiniAssignment.service.UserService;
import com.MiniAssignment.repo.UserRepo;
import com.MiniAssignment.model.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo repo;
	
	//register new user by saving details
	@Override
	public void saveUser(User user) {
		repo.save(user);
	}
	
	//to check whether user with the email already exists
	@Override
	public boolean fetchUserByEmailId(String email) {
		if(repo.findByEmailId(email)!=null) {
			return false;
		}
		return true;
	}
	
	//to check if the user with given email and password exists
	@Override
	public boolean fetchUserByEmailIdAndPassword(String email, String pass) {
		if(repo.findByEmailIdAndPassword(email, pass)!=null) {
			return true;
		}
		return false;
	}
}
