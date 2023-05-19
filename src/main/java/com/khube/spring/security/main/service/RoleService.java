package com.khube.spring.security.main.service;

import java.util.List;

import com.khube.spring.security.main.entity.Role;
import com.khube.spring.security.main.request.RoleRequest;
import com.khube.spring.security.main.response.RoleResponse;

public interface RoleService {

	public RoleRequest saveRole(Role role);
	
	public List<RoleResponse> getRoles();
}
