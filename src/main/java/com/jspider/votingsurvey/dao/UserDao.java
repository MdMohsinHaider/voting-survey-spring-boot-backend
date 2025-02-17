package com.jspider.votingsurvey.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspider.votingsurvey.entity.User;
import com.jspider.votingsurvey.repository.UserRepository;

@Repository
public class UserDao implements UsersDao {

	@Autowired
	private UserRepository repository;
	
	@Override
	public User saveUserDao(User user) {
		return repository.save(user);
	}
}
