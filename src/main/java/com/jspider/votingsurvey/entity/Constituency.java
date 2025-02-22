package com.jspider.votingsurvey.entity;

import java.io.Serializable;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "constituencies")
public class Constituency implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "constituency_number", nullable = false, unique = true)
    private Long id; // primary key

    @Column(name = "constituency_name", nullable = false, unique = true)
    private String name;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "is_election_active", columnDefinition = "BOOLEAN")
    private boolean electionActive;  // Renamed to avoid Lombok conflict

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_of_last_survey", columnDefinition = "DATE", nullable = true)
    private LocalDate dOLS;
}
