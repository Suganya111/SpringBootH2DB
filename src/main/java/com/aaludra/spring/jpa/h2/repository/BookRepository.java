package com.aaludra.spring.jpa.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aaludra.spring.jpa.h2.model.BookModel;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Long> {

}
