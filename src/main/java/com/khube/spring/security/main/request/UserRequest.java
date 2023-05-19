package com.khube.spring.security.main.request;

import java.util.Set;

import com.khube.spring.security.main.entity.Role;

public class UserRequest {

	private Integer userId;
	private String userName;
	private String password;
	private String email;
	private Set<Role> roles;
	
	public UserRequest() {
	}

	public UserRequest(Integer userId, String userName, String password, String email, Set<Role> roles) {
		super();
		this.userId = userId;
		this.userName = userName;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
		return "UserRequest [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", roles=" + roles + "]";
	}

}
