package com.khube.spring.security.main.helper;

import com.khube.spring.security.main.entity.User;
import com.khube.spring.security.main.request.UserRequest;
import com.khube.spring.security.main.response.UserResponse;

public class UserHelper {

	private static UserRequest userRequest = new UserRequest();
	
	public static UserRequest setUserDetailsForRequest(User user) {
		userRequest.setUserId(user.getUserId());
		userRequest.setUsername(user.getUsername());
		userRequest.setPassword(user.getPassword());
		userRequest.setEmail(user.getEmail());
		userRequest.setRoles(user.getRoles());
		return userRequest;
	}
	
	public static UserResponse setUserDetailsForMultiObjectForResponse(User user) {
		UserResponse userResponse = new UserResponse();
		userResponse.setUserId(user.getUserId());
		userResponse.setUsername(user.getUsername());
		userResponse.setPassword(user.getPassword());
		userResponse.setEmail(user.getEmail());
		userResponse.setRoles(user.getRoles());
		return userResponse;
	}
}
