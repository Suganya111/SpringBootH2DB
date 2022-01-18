package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Bank_Acc;
public interface BankDao extends JpaRepository<Bank_Acc,Long>{

}
