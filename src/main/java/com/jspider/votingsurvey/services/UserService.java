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

	@Override
	public Optional<User> getUserByVoterId(Long vId) {
		return dao.getUserByVoterId(vId);
	}

	@Override
    public Optional<User> getUserByEmail(String email) {
        return dao.getUserByEmail(email);
    }
	
	
	// Authorization User
	@Override 									// voterId and password from client side
	public boolean loginUserByVoterIdAndPassword(Long voterId, String password) { 
		Optional<User> optional = getUserByVoterId(voterId);
		if (!(optional.isPresent())) {
			return false;
		}
		User user = optional.get();
	
		Long dbVoterId = user.getVoterId(); // From DB
		String dbPassword = user.getPassword(); // From DB
		
		if (voterId.equals(dbVoterId) && password.equals(dbPassword)) {
			return true;
		}
		return false;
		
	}
}

