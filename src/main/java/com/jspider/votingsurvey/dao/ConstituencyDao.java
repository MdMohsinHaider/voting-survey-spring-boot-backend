package com.jspider.votingsurvey.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspider.votingsurvey.entity.Constituency;
import com.jspider.votingsurvey.repository.ConstituencyRepository;

@Repository
public class ConstituencyDao implements ConstituencysDao {

	@Autowired
	private ConstituencyRepository repository;
	
	@Override
	public Constituency saveConstituencyDao(Constituency constituency) {
		return repository.save(constituency);
	}
	
	@Override
	public List<Constituency> saveMultipleConstituencyDao(List<Constituency> constituencyList) {
		return repository.saveAll(constituencyList);
	}

	@Override
	public List<Constituency> getAllConstituencyDao() {
		return repository.findAll();
	}

	@Override
	public Optional<Constituency> getConstituencyByIdDao(Long id) {
		return repository.findById(id);
	}

	@Override
	public Optional<Constituency> getConstituencyByNameDao(String name) {
		return repository.findByName(name);
	}

	@Override
	public List<Constituency> getActiveConstituenciesDao() {
		return repository.findByElectionActiveTrue();
	}

	@Override
	public List<Constituency> getConstituenciesByStateDao(String state) {
		return repository.findByState(state);
	}

	@Override
	public List<Constituency> findConstituencyByIdOrNameDao(Long id, String name) {
		return repository.findByIdOrNameAndElectionActive(id, name);
	}

	
}
