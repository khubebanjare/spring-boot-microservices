package com.khube.spring.security.main.helper;

import com.khube.spring.security.main.entity.Role;
import com.khube.spring.security.main.request.RoleRequest;
import com.khube.spring.security.main.response.RoleResponse;

public class RoleHelper {

	private static RoleRequest roleRequest = new RoleRequest();
	
	public static RoleRequest setUserDetailsForRequest(Role role) {
		roleRequest.setRoleId(role.getRoleId());
		roleRequest.setRole(role.getRole());
		return roleRequest;
	}
	
	public static RoleResponse setUserDetailsForMultiObjectForResponse(Role role) {
		RoleResponse roleResponse = new RoleResponse();
		roleResponse.setRoleId(role.getRoleId());
		roleResponse.setRole(role.getRole());
		return roleResponse;
	}
}
