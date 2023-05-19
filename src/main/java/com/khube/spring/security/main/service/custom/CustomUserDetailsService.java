package com.khube.spring.security.main.service.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.khube.spring.security.main.entity.User;
import com.khube.spring.security.main.service.CustomUserService;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private CustomUserService customUserService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = customUserService.findByUserName(username);
		CustomUserDetails customUserDetails = null;
		if(user != null) {
			customUserDetails = new CustomUserDetails();
			customUserDetails.setUser(user);
		}
		else
			throw new UsernameNotFoundException("User Name Not Found for given user: " + username);
		return customUserDetails;
	}


}
