package com.jspider.votingsurvey.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.votingsurvey.dao.PartysDao;
import com.jspider.votingsurvey.entity.Constituency;
import com.jspider.votingsurvey.entity.Party;

@Service
public class PartyService implements PartysService {
	
	@Autowired
	private PartysDao dao;
	
	@Autowired
    private ConstituencysService constituencysService;

	@Override
	public Party saveParty(Party party) {
		if (party.getConstituency() != null && party.getConstituency().getId() != 0) {
            Optional<Constituency> constituencyOpt = constituencysService.getConstituencyById(party.getConstituency().getId());

            if (constituencyOpt.isPresent()) {
                party.setConstituency(constituencyOpt.get());
            } else {
                throw new RuntimeException("Constituency not found with ID: " + party.getConstituency().getId());
            }
        }
//        return dao.savePartyDao(party);
		Party savedParty = dao.savePartyDao(party);
		if (!savedParty.getConstituency().isElectionActive()) {
		    constituencysService.updateElectionStatus(savedParty.getConstituency().getId(), true);
		}
		return savedParty;

	}

	@Override
	public List<Party> getAllPartys() {
		return dao.getAllPartysDao();
	}

	@Override
	public List<Party> getPartiesByConstituency(Long constituencyId) {
		return dao.getPartiesByConstituencyDao(constituencyId);
	}

	@Override
	public boolean deletePartyByIdDao(Long Id) {
		return dao.deletePartyByIdDao(Id);
	}

//	@Override
//	public List<Party> getAllPartysByActiveConstituenciesNumber() {
//	    List<Constituency> activeConstituencies = constituencysService.getActiveConstituencies();
//	    if (activeConstituencies.isEmpty()) return List.of();
//	    Long constituencyId = activeConstituencies.get(0).getId();
//	    return getPartiesByConstituency(constituencyId);
//	}
	
	@Override
	public List<Party> getAllPartysByActiveConstituenciesNumber() {
	    List<Constituency> activeConstituencies = constituencysService.getActiveConstituencies();

	    if (activeConstituencies.isEmpty()) return List.of();

	    // Get the most recent active constituency (highest ID)
	    Long recentConstituencyId = activeConstituencies.stream()
	            .map(Constituency::getId)
	            .max(Long::compare)
	            .orElse(null);

	    return recentConstituencyId != null ? getPartiesByConstituency(recentConstituencyId) : List.of();
	}
	



	@Override
	public List<Party> getActiveElectionParties() {
		return dao.getActiveElectionPartiesDao();
	}

	@Override
	public boolean updateVotes(Long partyId, Long newVotes) {
		 return dao.updateVotesDao(partyId, newVotes);
	}

	@Override
	public List<Party> getPartiesByConstituencyIdOrName(Long constituencyId, String constituencyName) {
		
		if (constituencyId != null) {
            return dao.getPartiesByConstituencyDao(constituencyId);
        } else if (constituencyName != null && !constituencyName.isEmpty()) {
            return dao.getPartiesByConstituencyNameDao(constituencyName);
        }
        return List.of(); // Return empty list if both are null
	}

	@Override
	public String resetAllPartyVotesByConstituencyId(Long constituencyId) {
		int updateStatus = dao.resetAllPartyVotesByConstituencyIdDao(constituencyId);
		return updateStatus >0 ?  "All votes reset successfully." : "Error: No parties found in this constituency.";
		
	}
	
	
}
