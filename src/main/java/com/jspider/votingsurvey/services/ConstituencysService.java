package com.jspider.votingsurvey.services;

import java.util.List;
import java.util.Optional;

import com.jspider.votingsurvey.entity.Constituency;

public interface ConstituencysService {
	/**
     * Saves a constituency entity to the database.
     *
     * @param constituency the constituency entity to be saved
     * @return the saved constituency entity
     */
    Constituency saveConstituency(Constituency constituency);
    
    /**
     * Saves a multiple constituency entity to the database.
     *
     * @param constituency the constituency entity to be saved
     * @return the saved constituency list entity
     */
    List<Constituency> saveMultipleConstituency(List<Constituency> constituencyList);
    
    
    /**
     * Retrieves all constituency from the database.
     *
     * @return a list of all constituency
     */
    List<Constituency> getAllConstituency();
    
    /**
     * Retrieves a constituency by their unique identifier.
     *
     * @param id the ID of the constituency
     * @return an optional containing the constituency if found, otherwise empty
     */
    Optional<Constituency> getConstituencyById(Long id);
    
    /**
     * Retrieves a constituency by name.
     *
     * @param name the name of the constituency
     * @return an optional containing the constituency if found, otherwise empty
     */
    Optional<Constituency> getConstituencyByName(String name);
    
    List<Constituency> getActiveConstituencies();
    
    List<Constituency> getConstituenciesByState(String state);
    
 // Update election status for a specific constituency
    Constituency updateElectionStatus(Long id, boolean electionActive);
    
    List<Constituency> getConstituencyByIdOrName(Long id, String name);
    
    
    
}
