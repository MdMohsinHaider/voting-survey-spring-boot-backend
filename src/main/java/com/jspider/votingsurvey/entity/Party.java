package com.jspider.votingsurvey.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "political_parties")
public class Party {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	@Column(name = "partie_candidate_name", nullable = false)
	private String candidateName;
	
	@Column(name = "number_of_votes", nullable = false)
	private long numberOfVotes;
	
	@Column(name = "political_parties_symbol", nullable = false)
	private String img;
	
	@Column(name = "parties_candidate_img", nullable = false)
	private String candidateImg ;
	
	@ManyToOne
	@JoinColumn(name = "constituency_id", nullable = false)  // Foreign Key
	private Constituency constituency;
	
}
