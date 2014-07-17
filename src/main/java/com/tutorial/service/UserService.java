package com.tutorial.service;

import java.sql.SQLException;

import com.tutorial.model.User;

public interface UserService {

	public User getUserByUserName(String username);

	public int insertUser(User user)  throws SQLException;
}
