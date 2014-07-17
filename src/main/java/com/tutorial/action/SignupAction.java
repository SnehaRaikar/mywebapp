package com.tutorial.action;

import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.tutorial.model.User;
import com.tutorial.service.UserService;

public class SignupAction extends ActionSupport {
	
	private UserService userService;
	
	private User user;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String execute() {
		if(this.getUser() != null) {
			try {
				userService.insertUser(this.getUser());
			} catch (SQLException e) {
				e.printStackTrace();
				addActionError("There was a problem inserting your information. Please try again later.");
			}
		} else {
			return "FAILURE";
		}
		return "SUCCESS";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void validate() {
		if(StringUtils.isEmpty(this.getUser().getName())) {
			addActionError("Name is required.");
		} else if(StringUtils.isEmpty(this.getUser().getEmail())) {
			addActionError("Email is required.");
		} else if(StringUtils.isEmpty(this.getUser().getUsername())) {
			addActionError("Username is required.");
		} else if(StringUtils.isEmpty(this.getUser().getPassword())) {
			addActionError("Password is required.");
		} else if(StringUtils.isEmpty(this.getUser().getConfirmPassword())) {
			addActionError("Please confirm your password by re-entering it in the Confirm Password field.");
		} else if(!(StringUtils.equals(this.getUser().getPassword(), this.getUser().getConfirmPassword()))) {
			addActionError("Passwords do not match.");
		}
	}
		
}
