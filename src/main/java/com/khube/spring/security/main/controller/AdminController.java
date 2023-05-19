package com.khube.spring.security.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khube.spring.security.main.entity.User;
import com.khube.spring.security.main.request.UserRequest;
import com.khube.spring.security.main.response.UserResponse;
import com.khube.spring.security.main.service.UserService;

@RequestMapping("/auth/api")
@RestController
public class AdminController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PreAuthorize("hasAnyRole('admin')")
	@PostMapping(value = "/users")
	public ResponseEntity<UserRequest> createUser(@RequestBody User user){
		String userPassword = user.getPassword();
		String encryptPassword = passwordEncoder.encode(userPassword);
		user.setPassword(encryptPassword);
		System.out.println("user : " + user);
		UserRequest userRequest = userService.saveUser(user);
		return new ResponseEntity<UserRequest>(userRequest, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/users")
	public ResponseEntity<List<UserResponse>> getUsers(){
		List<UserResponse> userResponses = userService.getUsers();
		return new ResponseEntity<List<UserResponse>>(userResponses, HttpStatus.OK);
	}
}
