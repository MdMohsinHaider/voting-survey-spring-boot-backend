package com.jspider.votingsurvey.services;

import java.util.List;
import java.util.Optional;

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

	@Override
	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}

	@Override
	public Optional<User> getUserById(int id) {
		return dao.getUserById(id);
	}

	@Override
	public Optional<User> updateUserById(int id, User user) {
		return dao.updateUserById(id, user);
	}

	@Override
	public boolean deleteUserById(int id) {
		return dao.deleteUserById(id);
	}
}

