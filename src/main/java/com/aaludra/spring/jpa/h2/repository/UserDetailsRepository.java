package com.aaludra.spring.jpa.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aaludra.spring.jpa.h2.model.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails,Long> {

}
