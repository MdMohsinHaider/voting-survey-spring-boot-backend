package com.jspider.votingsurvey.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.votingsurvey.dao.UsersDao;
import com.jspider.votingsurvey.entity.User;

@Service
public class UserService implements UsersService {
	
	@Autowired
	private UsersDao dao;

	@Override
	public User saveUser(User user) {
		return dao.saveUserDao(user);
	}
}
