package com.aaludra.spring.jpa.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.aaludra.spring.jpa.h2.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {  
	
	

	//HttpStatus findByusernameAndemail(String username, String email);

}
