package com.jspider.votingsurvey.dao.dashboard;

import java.util.Optional;

import com.jspider.votingsurvey.entity.Admin;
import com.jspider.votingsurvey.repository.AdminRepository;

public class AdminImp implements AdminDao {
	
	private AdminRepository repository;

	@Override
	public Optional<Admin> getUserById(Long id) {
		return repository.findById(id);
	}

}
