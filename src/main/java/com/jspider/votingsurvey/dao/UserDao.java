package com.jspider.votingsurvey.dao;

import java.util.List;
import java.util.Optional;

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

	@Override
	public List<User> getAllUsers() {
		return repository.findAll();
	}

	@Override
	public Optional<User> getUserById(int id) {
		return repository.findById(id);
	}

	@Override
	public Optional<User> updateUserById(int id, User user) {
		Optional<User> optionalUser = repository.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();

            // Updating fields with new values from the request body
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setAge(user.getAge());
            existingUser.setGender(user.getGender());
            existingUser.setAddress(user.getAddress());
            existingUser.setConstituency(user.getConstituency());
            existingUser.setHasVoted(user.isHasVoted());

            // Save the updated user to the database
            repository.save(existingUser);

            return Optional.of(existingUser);
        }
        return Optional.empty();
	}

	@Override
	public boolean deleteUserById(int id) {
		Optional<User> user = repository.findById(id);
		if (user.isPresent()) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Optional<User> getUserByVoterId(Long vId) {
		return repository.findByVoterId(vId);
	}

	@Override
    public Optional<User> getUserByEmail(String email) {
        return repository.findByEmail(email);
    }
}
