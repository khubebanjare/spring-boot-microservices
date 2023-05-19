package com.khube.spring.security.main.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Table(name = "user_tab")	
@Entity
public class User {
	
	@Id
	private Integer userId;
	
	@NotNull
	private String username;
	@NotNull
	private String password;
	@Email
	@NotNull
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(		name = "user_role", 
					joinColumns =  @JoinColumn(name = "user_id"),
					inverseJoinColumns = @JoinColumn(name = "role_id")
			)
	private Set<Role> roles;
	
	public User() {
	}

	public User(Integer userId, @NotNull String username, @NotNull String password, @Email @NotNull String email,
			Set<Role> roles) {
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
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", roles=" + roles + "]";
	}
	
}
