package com.jspider.votingsurvey.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspider.votingsurvey.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	
}
