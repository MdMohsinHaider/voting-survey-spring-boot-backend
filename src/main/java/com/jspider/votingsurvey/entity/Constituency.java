package com.jspider.votingsurvey.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "constituencies")
public class Constituency implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "constituency_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "constituency_name", nullable = false, unique = true)
    private String name;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "is_election_active", nullable = false)
    private boolean isElectionActive;

    @OneToMany(mappedBy = "constituency", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<User> voters = new HashSet<>();


}
