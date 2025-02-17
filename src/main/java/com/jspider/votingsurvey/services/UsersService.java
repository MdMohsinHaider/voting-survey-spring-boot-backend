package com.jspider.votingsurvey.services;

import com.jspider.votingsurvey.entity.User;

public interface UsersService {
	
	/**
     * Saves a new user in the database.
     *
     * @param user The user to be saved.
     * @return The saved user with a generated ID.
     */
	User saveUser(User user);
}
