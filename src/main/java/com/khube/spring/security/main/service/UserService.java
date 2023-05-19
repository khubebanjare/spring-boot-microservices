package com.khube.spring.security.main.service;

import java.util.List;
import java.util.Optional;

import com.khube.spring.security.main.entity.User;
import com.khube.spring.security.main.request.UserRequest;
import com.khube.spring.security.main.response.UserResponse;

public interface UserService {

	public UserRequest saveUser(User user);
	
	public List<UserResponse> getUsers();
	
	public Optional<UserResponse> getUserById(Integer userId);
	
	public String deleteUserById(Integer userId);
	
}
