package com.charlie.online.foodchain.controller;

import com.charlie.online.foodchain.entities.User;
import com.charlie.online.foodchain.services.UserService;
import com.charlie.online.foodchain.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class AccountController {

	public static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	private UserService userService;
	


	// request method to create a new account by a guest
	@CrossOrigin
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody User newUser) {
		if (userService.find(newUser.getUsername()) != null) {
			logger.error("username Already exist " + newUser.getUsername());
			return new ResponseEntity(
					new CustomErrorType("user with username " + newUser.getUsername() + "already exist "),
					HttpStatus.CONFLICT);
		}
		//newUser.setRole("USER");
		
		return new ResponseEntity<User>(userService.save(newUser), HttpStatus.CREATED);
	}

	@CrossOrigin
	@RequestMapping(value = "/update-profile", method = RequestMethod.POST)
	public ResponseEntity<?> updateUser(@RequestBody User newUser) {
		return new ResponseEntity<User>(userService.update(newUser), HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> loginUser(@RequestBody User newUser) {

		User user =  userService.findByCredentials(newUser.getUsername(), newUser.getPassword());

		if(user == null) {
			return new ResponseEntity(
					new CustomErrorType("user with username " + newUser.getUsername() + "already exist "),
					HttpStatus.CONFLICT);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
