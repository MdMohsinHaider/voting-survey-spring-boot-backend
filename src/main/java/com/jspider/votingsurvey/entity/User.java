package com.jspider.votingsurvey.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users") 
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
	@Column(name = "voter_id", nullable = false, unique = true)
    private Long voterId;
	
    private String name;
    
    private String email;
    
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    
    private int age;
    private String gender;
    private String address;
    
    @Column(name = "constituency", nullable = false)
    private String constituency;
    
    private Long constituencyNumber;
    
    @Column(name = "has_voted", nullable = false)
    private boolean hasVoted;
    

	
}
