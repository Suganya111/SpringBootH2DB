package com.aaludra.spring.jpa.h2.controller;

import java.util.List;
//import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aaludra.spring.jpa.h2.model.User;
import com.aaludra.spring.jpa.h2.model.UserDetails;
import com.aaludra.spring.jpa.h2.repository.UserDetailsRepository;
import com.aaludra.spring.jpa.h2.repository.UserRepository;
//import com.aaludra.spring.jpa.h2.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserDetailsRepository userDetailsRepository;

	@PostMapping("/create")
	public ResponseEntity<User> save(@RequestBody User user) {
		try {
			return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUser() {
		try {
			List<User> list = userRepository.findAll();
			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<User>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getSingleUser(@PathVariable Long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return new ResponseEntity<User>(user.get(), HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);

	}

	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		try {
			return new ResponseEntity<User>(userRepository.save(user), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("users/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
		try {
			Optional<User> user = userRepository.findById(id);
			if (user.isPresent()) {
				userRepository.delete(user.get());
			}
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	/*
	 * @GetMapping("getByusernameAndemail/{username}{email}") public
	 * ResponseEntity<HttpStatus> getByUsernameAndEmail(@PathVariable String
	 * Username, @PathVariable String Email) { return new
	 * ResponseEntity<>(userRepository.findByusernameAndemail(Username, Email)); }
	 */
}
