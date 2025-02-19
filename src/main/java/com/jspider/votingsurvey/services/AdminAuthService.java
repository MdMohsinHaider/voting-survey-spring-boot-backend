package com.jspider.votingsurvey.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.votingsurvey.dao.dashboard.AdminDao;
import com.jspider.votingsurvey.entity.Admin;

@Service
public class AdminAuthService implements AdminService {

	@Autowired
	private AdminDao dao;

	@Override
	public Optional<Admin> getAdminById(Long id) {
		return dao.getAdminByIdDao(id);
	}

	@Override
	public boolean authAdminByIdAndPassword(Long id, String password) {

		Optional<Admin> optional = getAdminById(id);
		if (!(optional.isPresent())) return false;
		
		Admin admin = optional.get();
		if (id.equals(admin.getId()) && password.equals(admin.getPassword())) return true;
		
		return false;
	}
	
	
}

