package com.jspider.votingsurvey.services;

import java.util.List;

import com.jspider.votingsurvey.entity.Party;

public interface PartysService {
	
	/**
     * Saves a part entity to the database.
     *
     * @param part the part entity to be saved
     * @return the saved part entity
     */
	Party saveParty(Party party);
	
	/**
     * Retrieves all party from the database.
     *
     * @return a list of all party
     */
    List<Party> getAllPartys();
    
    boolean deletePartyByIdDao(Long Id);
    
    List<Party> getAllPartysByActiveConstituenciesNumber();
    
    List<Party> getActiveElectionParties();
    
    List<Party> getPartiesByConstituency(Long constituencyId);
    
    List<Party> getPartiesByConstituencyIdOrName(Long constituencyId, String constituencyName);
    
    boolean updateVotes(Long partyId, Long newVotes);
    
    String resetAllPartyVotesByConstituencyId(Long constituencyId);
    
    
}
