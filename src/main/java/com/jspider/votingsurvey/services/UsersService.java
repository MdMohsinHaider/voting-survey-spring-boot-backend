package com.jspider.votingsurvey.services;

import java.util.List;
import java.util.Optional;

import com.jspider.votingsurvey.entity.User;

public interface UsersService {
	
	/**
     * Saves a new user in the database.
     *
     * @param user The user to be saved.
     * @return The saved user with a generated ID.
     */
	User saveUser(User user);
	
	/**
     * Retrieves all users from the database.
     *
     * @return A list of all users.
     */
	List<User> getAllUsers();
	
	/**
     * Fetches a user by their unique ID.
     *
     * @param id The ID of the user.
     * @return An Optional containing the user if found, otherwise empty.
     */
	Optional<User> getUserById(int id);
	
	/**
     * Updates a user by their ID with new details.
     *
     * @param id The ID of the user to update.
     * @param user The updated user details.
     * @return An Optional containing the updated user if the update is successful.
     */
	Optional<User> updateUserById(int id, User user);
	
	/**
     * Deletes a user by their ID.
     *
     * @param id The ID of the user to delete.
     * @return true if the deletion was successful, false otherwise.
     */
	boolean deleteUserById(int id);
	
	/**
     * Retrieves a user by their Voter ID.
     *
     * @param vId The unique voter ID of the user.
     * @return An Optional containing the user if found, otherwise empty.
     */
	public Optional<User> getUserByVoterId(Long vId);
	
	/**
     * Retrieves a user by their email.
     *
     * @param email The email of the user.
     * @return An Optional containing the user if found, otherwise empty.
     */
    Optional<User> getUserByEmail(String email);
    
    public List<User> getUsersByConstituency(String constituency);
    
 // Authorization User
 	public boolean loginUserByVoterIdAndPassword(Long voterId, String password);
 	
 	public List<User> updateVotingStatus(String constituency, boolean hasVoted);
 	
 	public User updateVotingStatusByUserVoterId(Long vId, boolean hasVoted);
 	
 	boolean resetVotesByConstituency(Long constituencyNumber);
	
	
}
