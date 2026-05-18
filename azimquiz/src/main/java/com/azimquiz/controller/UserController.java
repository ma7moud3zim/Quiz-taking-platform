package com.azimquiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azimquiz.Service.User.UserService;
import com.azimquiz.entities.User;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/sign-up")
	public ResponseEntity<?> signupUser(@RequestBody User user) {
		if(userService.hasUserWithEmail(user.getEmail())) {
			return new ResponseEntity<>("User already exist",HttpStatus.NOT_ACCEPTABLE);
		}
		
		User createdUser = userService.createUser(user);
		if(createdUser == null) {
			return new ResponseEntity<>("Failed to create user",HttpStatus.NOT_ACCEPTABLE);
		}
		
		return ResponseEntity.ok(createdUser);
	}
}
