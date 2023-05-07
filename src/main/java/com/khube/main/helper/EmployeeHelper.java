package com.khube.main.helper;

import com.khube.main.entity.Employee;
import com.khube.main.request.EmployeeRequest;
import com.khube.main.response.EmployeeResponse;

public class EmployeeHelper {
    private static EmployeeRequest employeeRequest = new EmployeeRequest();
    private static EmployeeResponse employeeResponse = new EmployeeResponse();
    public static EmployeeRequest setEmployeeDetailsForRequest(Employee employee){
        employeeRequest.setEmpId(employee.getEmpId());
        employeeRequest.setFirstName(employee.getFirstName());
        employeeRequest.setLastName(employee.getLastName());
        employeeRequest.setFatherName(employee.getFatherName());
        employeeRequest.setAge(employee.getAge());
        employeeRequest.setEmail(employee.getEmail());
        employeeRequest.setMobileNumber(employee.getMobileNumber());
        employeeRequest.setSalary(employee.getSalary());
        return employeeRequest;
    }

    public static EmployeeResponse setEmployeeDetailsForResponse(Employee employee){
        employeeResponse.setEmpId(employee.getEmpId());
        employeeResponse.setFirstName(employee.getFirstName());
        employeeResponse.setLastName(employee.getLastName());
        employeeResponse.setFatherName(employee.getFatherName());
        employeeResponse.setAge(employee.getAge());
        employeeResponse.setEmail(employee.getEmail());
        employeeResponse.setMobileNumber(employee.getMobileNumber());
        employeeResponse.setSalary(employee.getSalary());
        return employeeResponse;
    }

    public static EmployeeResponse setEmployeeDetailsForMultiObjectResponse(Employee employee){
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setEmpId(employee.getEmpId());
        employeeResponse.setFirstName(employee.getFirstName());
        employeeResponse.setLastName(employee.getLastName());
        employeeResponse.setFatherName(employee.getFatherName());
        employeeResponse.setAge(employee.getAge());
        employeeResponse.setEmail(employee.getEmail());
        employeeResponse.setMobileNumber(employee.getMobileNumber());
        employeeResponse.setSalary(employee.getSalary());
        return employeeResponse;
    }
}
