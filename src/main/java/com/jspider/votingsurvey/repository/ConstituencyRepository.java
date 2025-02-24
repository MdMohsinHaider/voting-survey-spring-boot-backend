package com.jspider.votingsurvey.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jspider.votingsurvey.entity.Constituency;

public interface ConstituencyRepository extends JpaRepository<Constituency, Long> {
	
	Optional<Constituency> findByName(String name);
	List<Constituency> findByElectionActiveTrue();
	List<Constituency> findByState(String state);
	
	@Query("SELECT c FROM Constituency c WHERE (c.id = :id OR c.name = :name) ")
    List<Constituency> findByIdOrNameAndElectionActive(@Param("id") Long id, @Param("name") String name);
}

