package com.jspider.votingsurvey.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jspider.votingsurvey.entity.Party;
import com.jspider.votingsurvey.repository.PartyRepository;

@Repository
public class PartyDao implements PartysDao {
	
	@Autowired
	private PartyRepository repository;

	@Override
	public List<Party> getPartiesByConstituencyDao(Long constituencyId) {
		return repository.findByConstituencyId(constituencyId);
	}

	@Override
	public Party savePartyDao(Party party) {
		return repository.save(party);
	}

	@Override
	public List<Party> getAllPartysDao() {
		return repository.findAll();
	}

	@Override
	public boolean deletePartyByIdDao(Long Id) {
		if (Id != null) {
			repository.deleteById(Id);			
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public List<Party> getActiveElectionPartiesDao() {
		return repository.findByElectionActiveConstituency();
	}

	@Override
	@Transactional
	public boolean updateVotesDao(Long partyId, Long newVotes) {
		int updatedRows = repository.updateNumberOfVotesById(partyId, newVotes);
		return updatedRows >0;
	}

	@Override
	public List<Party> getPartiesByConstituencyNameDao(String constituencyName) {
		return repository.findByConstituencyName(constituencyName);
	}

	@Override
	public int resetAllPartyVotesByConstituencyIdDao(Long constituencyId) {
		return repository.resetAllPartyVotesByConstituencyId(constituencyId);
	}	
}
