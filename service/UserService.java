package com.ar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ar.dao.UserDao;
import com.ar.model.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	public User verifyUser(String userName, String userPassword){
		
		return userDao.verifyUser(userName, userPassword);
	}
}
