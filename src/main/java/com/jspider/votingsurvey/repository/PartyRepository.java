package com.jspider.votingsurvey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.jspider.votingsurvey.entity.Party;

public interface PartyRepository extends JpaRepository<Party, Long> {
	
	List<Party> findByConstituencyId(Long constituencyId);
	
	@Query("SELECT p FROM Party p WHERE p.constituency.name = :constituencyName")
    List<Party> findByConstituencyName(@Param("constituencyName") String constituencyName);
	
	@Query("SELECT p FROM Party p WHERE p.constituency.electionActive = true")
    List<Party> findByElectionActiveConstituency();
	
	@Modifying
    @Transactional
    @Query("UPDATE Party p SET p.numberOfVotes = :numberOfVotes WHERE p.id = :partyId")
    int updateNumberOfVotesById(Long partyId, Long numberOfVotes);
	
	@Modifying
	@Transactional
	@Query("UPDATE Party p SET p.numberOfVotes = 0 WHERE p.constituency.id = :constituencyId")
	int resetAllPartyVotesByConstituencyId(@Param("constituencyId") Long constituencyId);

}
