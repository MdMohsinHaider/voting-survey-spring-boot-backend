package com.jspider.votingsurvey.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


import com.jspider.votingsurvey.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	
	// Find a user by Email
	Optional<User> findByEmail(String email);
	
	// Find a user by Voter ID
	Optional<User> findByVoterId(Long voterId);
	
	List<User> findByConstituency(String constituency);
	
	@Modifying
    @Transactional
    @Query("UPDATE User u SET u.hasVoted = false WHERE u.constituencyNumber = :constituencyNumber AND u.hasVoted = true")
    int resetHasVotedByConstituencyNumber(Long constituencyNumber);
}
