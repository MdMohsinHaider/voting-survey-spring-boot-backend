package com.jspider.votingsurvey.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspider.votingsurvey.entity.Constituency;

public interface ConstituencyRepository extends JpaRepository<Constituency, Long> {
	
	Optional<Constituency> findByName(String name);
	List<Constituency> findByElectionActiveTrue();
	List<Constituency> findByState(String state);
}

