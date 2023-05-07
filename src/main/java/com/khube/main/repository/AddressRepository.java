package com.khube.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.khube.main.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
	
	public Address findAddressByEmpId(@Param("empId") Integer empId);
}
