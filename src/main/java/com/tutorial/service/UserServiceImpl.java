package com.tutorial.service;

import java.sql.SQLException;

import com.tutorial.dao.UserDao;
import com.tutorial.model.User;

public class UserServiceImpl implements UserService{
	
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User getUserByUserName(String username) {
		return userDao.getUserByUserName(username);
	}

	public int insertUser(User user)  throws SQLException  {
		return userDao.insertUser(user);
	}

}
