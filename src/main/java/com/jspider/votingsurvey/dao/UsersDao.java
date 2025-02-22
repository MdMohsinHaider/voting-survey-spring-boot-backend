package com.jspider.votingsurvey.dao;

import java.util.List;
import java.util.Optional;

import com.jspider.votingsurvey.entity.User;

public interface UsersDao {
	
	/**
     * Saves a user entity to the database.
     *
     * @param user the user entity to be saved
     * @return the saved user entity
     */
    User saveUserDao(User user);
    
    /**
     * Saves a user entity to the database.
     *
     * @param user the user entity to be saved
     * @return the saved user entity
     */
    List<User> saveAllUserDao(List<User> users);
    
    /**
     * Retrieves all users from the database.
     *
     * @return a list of all users
     */
    List<User> getAllUsers();
    
    /**
     * Retrieves a user by their unique identifier.
     *
     * @param id the ID of the user
     * @return an optional containing the user if found, otherwise empty
     */
    Optional<User> getUserById(int id);
    
    /**
     * Updates a user identified by their ID with new details.
     *
     * @param id the ID of the user to be updated
     * @param user the updated user entity
     * @return an optional containing the updated user if the update was successful, otherwise empty
     */
    Optional<User> updateUserById(int id, User user);

    /**
     * Deletes a user from the database by their ID.
     *
     * @param id the ID of the user to be deleted
     * @return {@code true} if the deletion was successful, otherwise {@code false}.
     */
    boolean deleteUserById(int id);
    
    /**
     * Retrieves a user by their Voter ID.
     *
     * @param vId The unique voter ID of the user.
     * @return An Optional containing the user if found, otherwise empty.
     */
    Optional<User> getUserByVoterId(Long vId);
    
    /**
     * Retrieves a user by their email.
     *
     * @param email The email of the user.
     * @return An Optional containing the user if found, otherwise empty.
     */
    Optional<User> getUserByEmail(String email);
    
    List<User> getUsersByConstituencyDao(String constituency);
    
    boolean resetVotesByConstituencyDao(Long constituencyNumber);
}
