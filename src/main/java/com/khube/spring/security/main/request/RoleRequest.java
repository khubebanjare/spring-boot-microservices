package com.khube.spring.security.main.request;

public class RoleRequest {

	private Integer roleId;
	private String role;
	
	
	public RoleRequest() {
	}

	public RoleRequest(Integer roleId, String role) {
		super();
		this.roleId = roleId;
		this.role = role;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "RoleRequest [roleId=" + roleId + ", role=" + role + "]";
	}
	
	
}
