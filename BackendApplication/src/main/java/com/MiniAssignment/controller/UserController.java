package com.MiniAssignment.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.MiniAssignment.model.User;
import com.MiniAssignment.service.UserService;

@RestController
public class UserController {

	@Autowired 
	private UserService service;
	
	//********************* REGISTER API *************************************
	
		@PostMapping("/register")
		@CrossOrigin(origins="http://localhost:4200")
		public boolean registerUser(@RequestBody User user) throws Exception {
			String tempEmail = user.getEmailId();
			if(tempEmail!=null && !"".equals(tempEmail)) {
				boolean doesExist = service.fetchUserByEmailId(tempEmail);
				if(!doesExist) {
					throw new Exception("User already exists!");
				}
			}
			service.saveUser(user);
			return true;
		}
		
	//********************* LOGIN API *************************************
		
		@PostMapping(path="/login")
		@CrossOrigin(origins="http://localhost:4200")
		public boolean loginUser(@RequestBody User user)throws Exception  {
			String tempEmail = user.getEmailId();
			String tempPass = user.getPassword();
			boolean doesUserExist;
			if(tempEmail!=null && tempPass!=null) {
				doesUserExist= service.fetchUserByEmailIdAndPassword(tempEmail, tempPass);
				if(!doesUserExist) {
					throw new Exception("Wrong credentials!");
				}
			}
			return true;
		}

}
