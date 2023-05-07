package com.khube.main.service;

import com.khube.main.entity.Employee;
import com.khube.main.request.EmployeeRequest;
import com.khube.main.response.EmployeeResponse;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public EmployeeRequest saveEmployee(Employee employee);

    //public List<EmployeeResponse> getEmployees();
    public List<EmployeeResponse> getEmployees();

    public Optional<EmployeeResponse> getEmployeeByEmpId(Integer empId);
}
