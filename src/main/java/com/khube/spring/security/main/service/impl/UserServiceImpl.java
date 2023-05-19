package com.khube.spring.security.main.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khube.spring.security.main.entity.User;
import com.khube.spring.security.main.exception.UserAlreadyExistException;
import com.khube.spring.security.main.exception.UserNotFoundException;
import com.khube.spring.security.main.helper.UserHelper;
import com.khube.spring.security.main.repository.UserRepository;
import com.khube.spring.security.main.request.UserRequest;
import com.khube.spring.security.main.response.UserResponse;
import com.khube.spring.security.main.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserRequest saveUser(User user) {
		if(userRepository.existsById(user.getUserId()))
			throw new UserAlreadyExistException("User Already present");
		
		User newUser = userRepository.save(user);
		UserRequest userRequest = UserHelper.setUserDetailsForRequest(newUser);
		return userRequest;
	}

	@Override
	public List<UserResponse> getUsers() {
		List<User> users = userRepository.findAll();
		List<UserResponse> userResponses = new ArrayList<UserResponse>();
		
		if(!users.isEmpty()) {
			users.forEach(user ->{
			UserResponse userResponse = UserHelper.setUserDetailsForMultiObjectForResponse(user);
			userResponses.add(userResponse);
			});
		}
		else
			throw new UserNotFoundException("User Not Found");
		return userResponses;
	}

	@Override
	public Optional<UserResponse> getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public String deleteUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
