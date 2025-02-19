package com.jspider.votingsurvey.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;


@Getter
@Entity
@Table(name = "admin") 
public class Admin {
	
	@Id
	private Long id;
    private Long voterId;
    private String password;
}
