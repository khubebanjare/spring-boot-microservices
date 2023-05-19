package com.khube.spring.security.main.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khube.spring.security.main.entity.Role;
import com.khube.spring.security.main.exception.RoleAlreadyExistException;
import com.khube.spring.security.main.exception.RoleNotFoundException;
import com.khube.spring.security.main.helper.RoleHelper;
import com.khube.spring.security.main.repository.RoleReposiroty;
import com.khube.spring.security.main.request.RoleRequest;
import com.khube.spring.security.main.response.RoleResponse;
import com.khube.spring.security.main.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleReposiroty roleRepository;

	@Override
	public RoleRequest saveRole(Role role) {
		if(roleRepository.existsById(role.getRoleId()))
			throw new RoleAlreadyExistException("Role Already Present..");
		
		Role newRole = roleRepository.save(role);
		RoleRequest roleRequest = RoleHelper.setUserDetailsForRequest(newRole);
		return roleRequest;
	}

	@Override
	public List<RoleResponse> getRoles() {
		List<Role> roles = roleRepository.findAll();
		List<RoleResponse> roleResponses = new ArrayList<RoleResponse>();
		
		if(roles.isEmpty()) {
			roles.forEach(role -> {
				RoleResponse roleResponse = RoleHelper.setUserDetailsForMultiObjectForResponse(role);
				roleResponses.add(roleResponse);
			});
		}
		else
			throw new RoleNotFoundException("Role Not Found..");
		return roleResponses;
	}
	
	

}
