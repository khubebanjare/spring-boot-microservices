package com.khube.spring.security.main.response;

public class RoleResponse {

	private Integer roleId;
	private String role;
	
	public RoleResponse() {
	}

	public RoleResponse(Integer roleId, String role) {
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
		return "RoleResponse [roleId=" + roleId + ", role=" + role + "]";
	}
	
}
