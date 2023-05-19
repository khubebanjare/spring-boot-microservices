package com.khube.spring.security.main.service;

import com.khube.spring.security.main.entity.User;

public interface CustomUserService {

	public User findByUserName(String userName);
}
