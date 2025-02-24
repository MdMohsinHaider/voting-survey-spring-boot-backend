package com.jspider.votingsurvey.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.votingsurvey.dao.ConstituencysDao;
import com.jspider.votingsurvey.entity.Constituency;

@Service
public class ConstituencyService implements ConstituencysService {

	@Autowired
	private ConstituencysDao dao;
	
	@Override
	public Constituency saveConstituency(Constituency constituency) {
		
		if (constituency.getDOLS() == null) {
		    constituency.setDOLS(LocalDate.now());
		}

		return dao.saveConstituencyDao(constituency);
	}

	@Override
	public List<Constituency> saveMultipleConstituency(List<Constituency> constituencyList) {
		return dao.saveMultipleConstituencyDao(constituencyList);
	}

	@Override
	public List<Constituency> getAllConstituency() {
		return dao.getAllConstituencyDao();
	}

	@Override
	public Optional<Constituency> getConstituencyById(Long id) {
		return dao.getConstituencyByIdDao(id);
	}

	@Override
	public Optional<Constituency> getConstituencyByName(String name) {
		return dao.getConstituencyByNameDao(name);
	}

	@Override
	public List<Constituency> getActiveConstituencies() {
		return dao.getActiveConstituenciesDao();
	}

	@Override
	public List<Constituency> getConstituenciesByState(String state) {
		return dao.getConstituenciesByStateDao(state);
	}

	@Override
	public Constituency updateElectionStatus(Long id, boolean electionActive) {
		Optional<Constituency> optional = getConstituencyById(id);
		if (optional.isPresent()) {
			Constituency constituency = optional.get();
			constituency.setElectionActive(electionActive);
			if (electionActive) constituency.setDOLS(LocalDate.now());
			return dao.saveConstituencyDao(constituency);
		}
		return null;
	}

	@Override
	public List<Constituency> getConstituencyByIdOrName(Long id, String name) {
		return dao.findConstituencyByIdOrNameDao(id, name);
	}
}
