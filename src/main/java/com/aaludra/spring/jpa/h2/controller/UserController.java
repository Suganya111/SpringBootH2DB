package com.aaludra.spring.jpa.h2.controller;

import java.util.List;
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
//import com.aaludra.spring.jpa.h2.repository.UserDetailsRepository;
import com.aaludra.spring.jpa.h2.repository.UserRepository;
//import com.aaludra.spring.jpa.h2.util.Dateutil;
import com.aaludra.spring.jpa.h2.view.UserInputView;
import com.aaludra.spring.jpa.h2.view.UserOutputView;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserRepository userRepository;

	/*
	 * @PostMapping("/create") public ResponseEntity<UserDetails> save(@RequestBody
	 * UserRequest userRequest) { try{ UserDetails ud = new
	 * UserDetails(userRequest);
	 * 
	 * ud.setAddress(userRequest.getAddress()); ud.setDob(userRequest.getDob());
	 * ud.setGender(userRequest.getGender());
	 * ud.setPhoneno(userRequest.getPhoneno()); User user = new User();
	 * user.setUsername(userRequest.getUsername());
	 * user.setEmail(userRequest.getEmail());
	 * user.setPassword(userRequest.getPassword());
	 * user.setStatus(userRequest.getStatus());
	 * user.setLogindetails(userRequest.getLogindetails()); ud.setUser(user);
	 * user.setUserDetails(ud); userRepository.save(user); return new
	 * ResponseEntity<UserDetails>(ud, HttpStatus.CREATED); }catch(Exception e) {
	 * return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); }
	 * 
	 * }
	 */

	@PostMapping("/create")
	public ResponseEntity<?> createuserview(@RequestBody UserInputView userInputView) {
		try {
			User user = this.builduser(userInputView);
			UserDetails ud = this.buildud(userInputView);
			ud.setUser(user);
			user.setUserDetails(ud);
			UserOutputView usout = this.buildout(userRepository.save(user));
			return new ResponseEntity<>(usout, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	public User builduser(UserInputView userInputView) {
		User user = new User();
		user.setUsername(userInputView.getUsername());
		user.setEmail(userInputView.getEmail());
		user.setPassword(userInputView.getPassword());
		user.setStatus(userInputView.getStatus());
		// user.setLogindetails(Dateutil.convertStringToDate(userInputView.getLogindetails()));
		return user;
	}

	public UserDetails buildud(UserInputView userInputView) {
		UserDetails ud = new UserDetails();
		// ud.setDob(Dateutil.convertStringToDate(userInputView.getDob()));
		ud.setPhoneno(userInputView.getPhoneno());
		ud.setGender(userInputView.getGender());
		ud.setAddress(userInputView.getAddress());
		return ud;
	}

	public UserOutputView buildout(User user) {
		UserOutputView usout = new UserOutputView();
		usout.setUsername(user.getUsername());
		usout.setEmail(user.getEmail());
		usout.setPassword(user.getPassword());
		usout.setLogindetails(user.getLogindetails().toString());
		usout.setStatus(user.getStatus());
		usout.setId(Long.toString(user.getId()));
		usout.setDob(user.getUserDetails().getDob().toString());
		usout.setGender(user.getUserDetails().getGender());
		usout.setAddress(user.getUserDetails().getAddress());
		usout.setPhoneno(user.getUserDetails().getPhoneno());
		return usout;

	}

	/*
	 * @PostMapping("/create") public ResponseEntity<User> save(@RequestBody User
	 * user) { try { return new ResponseEntity<>(userRepository.save(user),
	 * HttpStatus.CREATED);
	 * 
	 * } catch (Exception e) { return new
	 * ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); }
	 * 
	 * }
	 */

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
