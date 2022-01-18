package com.aaludra.spring.jpa.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aaludra.spring.jpa.h2.model.Bank_Acc;

public interface BankDao extends JpaRepository<Bank_Acc, Long>{

}
