package com.aaludra.spring.jpa.h2.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import com.aaludra.spring.jpa.h2.model.User;
import com.aaludra.spring.jpa.h2.model.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


	

}
	
	
	



	

	//List<User> user =new ArrayList<User>();
	

	


	
	

	//HttpStatus findByusernameAndemail(String username, String email);


