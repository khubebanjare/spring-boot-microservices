package com.khube.main.service.impl;

import com.khube.main.entity.Employee;
import com.khube.main.exception.AddressResponseEmpty;
import com.khube.main.exception.EmployeeAlreadyPresent;
import com.khube.main.exception.EmployeeIsNotPresent;
import com.khube.main.exception.EmployeeNotFoundException;
import com.khube.main.feignclient.AddressClient;
import com.khube.main.helper.EmployeeHelper;
import com.khube.main.repository.EmployeeRepository;
import com.khube.main.request.EmployeeRequest;
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
    private EmployeeRequest employeeRequest;

    @Autowired
    private AddressClient addressClient;

    @Override
    public EmployeeRequest saveEmployee(Employee employee) throws EmployeeAlreadyPresent {
        Employee existEmployee = employeeRepository.findById(employee.getEmpId()).get();
        if(existEmployee == null) {
            Employee newEmployee = employeeRepository.save(employee);
            employeeRequest = EmployeeHelper.setEmployeeDetailsForRequest(newEmployee);
        }
        else
            throw new EmployeeAlreadyPresent("Employee is already present!");
        return employeeRequest;
    }

    @Override
    public List<EmployeeResponse> getEmployees() throws EmployeeNotFoundException{
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeResponse> employeeResponses = new ArrayList<EmployeeResponse>();
        if(!employees.isEmpty()) {
            employees.forEach(employee -> {
                EmployeeResponse employeeResponse = EmployeeHelper.setEmployeeDetailsForMultiObjectResponse(employee);
                employeeResponses.add(employeeResponse);
            });
        }
        else
            throw new EmployeeNotFoundException("Employee Not Found");
        return employeeResponses;
    }

    @Override
    public Optional<EmployeeResponse> getEmployeeByEmpId(Integer empId) throws AddressResponseEmpty, EmployeeNotFoundException, EmployeeIsNotPresent {
        Employee  newEmployee = employeeRepository.findById(empId)
                                .orElseThrow(
                                        () -> new EmployeeIsNotPresent("Employee is not present for the given Id : " + empId));

        EmployeeResponse employeeResponse = EmployeeHelper.setEmployeeDetailsForResponse(newEmployee);
        AddressResponse addressResponse = addressClient.findAddressByEmpId(empId);

        if(addressResponse != null)
            employeeResponse.setAddressResponse(addressResponse);
        else
            throw new AddressResponseEmpty("Please provide Address Response to avoid NullPointerException");

        Optional<EmployeeResponse> employeeResponseOptional = Optional.of(employeeResponse);
        if (employeeResponseOptional.isPresent())
            return employeeResponseOptional;
        else
            throw new EmployeeNotFoundException("Employee is Not Found");
    }
}