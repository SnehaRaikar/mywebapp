package com.tutorial.dao;

import java.sql.SQLException;

import com.tutorial.model.User;

public interface UserDao {

	public User getUserByUserName(String username);

	public int insertUser(User user)  throws SQLException ;
}
