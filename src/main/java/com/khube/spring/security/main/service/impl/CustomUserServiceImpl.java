package com.khube.spring.security.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khube.spring.security.main.entity.User;
import com.khube.spring.security.main.repository.UserRepository;
import com.khube.spring.security.main.service.CustomUserService;

@Service
public class CustomUserServiceImpl implements CustomUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findByUserName(String username) {
		return userRepository.findByUsername(username);
	}

}
