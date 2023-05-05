package com.khube.main.helper;

import com.khube.main.entity.Employee;
import com.khube.main.response.EmployeeResponse;

public class EmployeeHelper {
    private static EmployeeResponse employeeResponse = new EmployeeResponse();
    public static EmployeeResponse setEmployeeDetails(Employee employee){
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

    public static EmployeeResponse setEmployeeDetailsForMultiObject(Employee employee){
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
