package com.khube.main.service.impl;

import com.khube.main.entity.Employee;
import com.khube.main.exception.EmployeeIsEmpty;
import com.khube.main.exception.EmployeeNotFoundException;
import com.khube.main.feignclient.AddressClient;
import com.khube.main.helper.EmployeeHelper;
import com.khube.main.repository.EmployeeRepository;
import com.khube.main.response.AddressResponse;
import com.khube.main.response.EmployeeResponse;
import com.khube.main.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeResponse employeeResponse;

    @Autowired
    private AddressClient addressClient;

    @Override
    public EmployeeResponse saveEmployee(Employee employee) {
        Employee newEmployee = employeeRepository.save(employee);
        if(newEmployee != null)
            employeeResponse = EmployeeHelper.setEmployeeDetails(newEmployee);
        else
            throw new EmployeeIsEmpty("Employee is Empty Please Insert employee data!!!");
        return employeeResponse;
    }

    @Override
    public List<EmployeeResponse> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeResponse> employeeResponses = new ArrayList<EmployeeResponse>();
        if(!employees.isEmpty()) {
            employees.forEach(employee -> {
                EmployeeResponse employeeResponse = EmployeeHelper.setEmployeeDetailsForMultiObject(employee);
                employeeResponses.add(employeeResponse);
            });
        }
        else
            throw new EmployeeIsEmpty("Employee is Empty");
        return employeeResponses;
    }

    @Override
    public Optional<EmployeeResponse> getEmployeeByEmpId(Integer empId) {
        Employee newEmployee = employeeRepository.findById(empId).get();
        if(newEmployee != null) {
           EmployeeResponse employeeResponse = EmployeeHelper.setEmployeeDetails(newEmployee);
            AddressResponse addressResponse = addressClient.findAddressByEmpId(empId);
            employeeResponse.setAddressResponse(addressResponse);
            Optional<EmployeeResponse> employeeResponseOptional = Optional.of(employeeResponse);
            if (employeeResponseOptional.isPresent())
                return employeeResponseOptional;
            else
                throw new EmployeeNotFoundException("Employee is Not Found for given Address ID");
        }
        else
            throw new EmployeeNotFoundException("Employee is Not Found for given Address ID");
    }
}