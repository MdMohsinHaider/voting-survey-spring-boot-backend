package com.jspider.votingsurvey.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspider.votingsurvey.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
