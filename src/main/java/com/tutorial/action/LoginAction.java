package com.tutorial.action;

import com.opensymphony.xwork2.ActionSupport;
import com.tutorial.model.User;
import com.tutorial.service.UserService;

public class LoginAction extends ActionSupport {
	
	private UserService userService;
	
	private String username;
	
	private String password;
	
	public void setUserService(UserService userService) {
		this.userService = userService; 
	}

	public String execute() {
		User user = this.userService.getUserByUserName(this.getUsername());
		if(user != null) {
			if(user.getPassword().equals(this.getPassword())) {
				return "SUCCESS";
			} else {
				addActionError("Please check the username and password you have entered");
				return "FAILURE";
			}
		} else {
			addActionError("Please check the username and password you have entered");
			return "FAILURE";
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
