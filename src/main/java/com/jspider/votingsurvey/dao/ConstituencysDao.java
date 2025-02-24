package com.jspider.votingsurvey.dao;

import java.util.List;
import java.util.Optional;

import com.jspider.votingsurvey.entity.Constituency;

public interface ConstituencysDao {
	
	/**
     * Saves a constituency entity to the database.
     *
     * @param constituency the constituency entity to be saved
     * @return the saved constituency entity
     */
    Constituency saveConstituencyDao(Constituency constituency);
    
    /**
     * Saves a multiple constituency entity to the database.
     *
     * @param constituency the constituency entity to be saved
     * @return the saved constituency list entity
     */
    List<Constituency> saveMultipleConstituencyDao(List<Constituency> constituencyList);
    
    
    /**
     * Retrieves all constituency from the database.
     *
     * @return a list of all constituency
     */
    List<Constituency> getAllConstituencyDao();
    
    /**
     * Retrieves a constituency by their unique identifier.
     *
     * @param id the ID of the constituency
     * @return an optional containing the constituency if found, otherwise empty
     */
    Optional<Constituency> getConstituencyByIdDao(Long id);
    
    /**
     * Retrieves a constituency by their unique identifier.
     *
     * @param name the name of the constituency
     * @return an optional containing the constituency if found, otherwise empty
     */
    Optional<Constituency> getConstituencyByNameDao(String name);
    
    List<Constituency> getActiveConstituenciesDao();
    
    List<Constituency> getConstituenciesByStateDao(String state);
    
    // AND c.electionActive = true/false
    List<Constituency> findConstituencyByIdOrNameDao(Long id, String name);

}
