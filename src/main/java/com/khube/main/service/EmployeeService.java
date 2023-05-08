package com.khube.main.service;

import com.khube.main.entity.Employee;
import com.khube.main.exception.AddressResponseEmpty;
import com.khube.main.exception.EmployeeAlreadyPresent;
import com.khube.main.exception.EmployeeIsNotPresent;
import com.khube.main.exception.EmployeeNotFoundException;
import com.khube.main.request.EmployeeRequest;
import com.khube.main.response.EmployeeResponse;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public EmployeeRequest saveEmployee(Employee employee) throws EmployeeAlreadyPresent;

    //public List<EmployeeResponse> getEmployees();
    public List<EmployeeResponse> getEmployees() throws EmployeeNotFoundException;

    public Optional<EmployeeResponse> getEmployeeByEmpId(Integer empId) throws AddressResponseEmpty, EmployeeNotFoundException, EmployeeIsNotPresent;
}
