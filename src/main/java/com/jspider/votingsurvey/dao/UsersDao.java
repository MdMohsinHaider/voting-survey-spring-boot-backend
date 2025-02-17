package com.jspider.votingsurvey.dao;

import com.jspider.votingsurvey.entity.User;

public interface UsersDao {
	
	/**
     * Saves a user entity to the database.
     *
     * @param user the user entity to be saved
     * @return the saved user entity
     */
    User saveUserDao(User user);
    
}
