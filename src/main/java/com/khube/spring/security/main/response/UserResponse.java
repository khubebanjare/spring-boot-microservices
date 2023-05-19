package com.khube.spring.security.main.response;

import java.util.Set;

import com.khube.spring.security.main.entity.Role;

public class UserResponse {

	private Integer userId;
	private String username;
	private String password;
	private String email;
	private Set<Role> roles;
	
	public UserResponse() {
	}

	public UserResponse(Integer userId, String username, String password, String email, Set<Role> roles) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.roles = roles;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer usrId) {
		this.userId = usrId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserResponse [userId=" + userId + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", roles=" + roles + "]";
	}

}
