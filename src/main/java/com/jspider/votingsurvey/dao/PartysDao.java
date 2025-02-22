package com.jspider.votingsurvey.dao;

import java.util.List;

import com.jspider.votingsurvey.entity.Party;

public interface PartysDao {

	/**
     * Saves a part entity to the database.
     *
     * @param part the part entity to be saved
     * @return the saved part entity
     */
	Party savePartyDao(Party party);
	
	/**
     * Retrieves all party from the database.
     *
     * @return a list of all party
     */
    List<Party> getAllPartysDao();
    
    boolean deletePartyByIdDao(Long Id);
    
    List<Party> getActiveElectionPartiesDao();
    
    public List<Party> getPartiesByConstituencyDao(Long constituencyId);
    
    boolean updateVotesDao(Long partyId, Long newVotes);
}
