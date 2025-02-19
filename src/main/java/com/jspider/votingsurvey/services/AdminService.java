package com.jspider.votingsurvey.services;

import java.util.Optional;

import com.jspider.votingsurvey.entity.Admin;

public interface AdminService {
	
	/**
     * Fetches a admin by their unique ID.
     *
     * @param id The ID of the admin.
     * @return An Optional containing the admin if found, otherwise empty.
     */
	Optional<Admin> getAdminById(Long id);
	
	// Authorization User
	public boolean authAdminByIdAndPassword(Long id, String password);
}
