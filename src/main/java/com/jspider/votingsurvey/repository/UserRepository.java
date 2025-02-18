package com.jspider.votingsurvey.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspider.votingsurvey.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	
	// Find a user by Email
	Optional<User> findByEmail(String email);
	
	// Find a user by Voter ID
	Optional<User> findByVoterId(Long voterId);
}
