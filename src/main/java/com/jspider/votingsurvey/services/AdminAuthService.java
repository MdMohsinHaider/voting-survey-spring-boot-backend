package com.jspider.votingsurvey.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jspider.votingsurvey.entity.Admin;

@Service
public class AdminAuthService implements AdminService {

	@Override
	public Optional<Admin> getUserById(Long id) {
		return Optional.empty();
	}

}
