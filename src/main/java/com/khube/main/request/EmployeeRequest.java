package com.khube.main.request;

import com.khube.main.response.AddressResponse;
import org.springframework.stereotype.Component;

@Component
public class EmployeeRequest {
    private Integer empId;
    private String firstName;
    private String lastName;
    private String fatherName;
    private Integer age;
    private String email;
    private Long mobileNumber;
    private Double salary;
    private AddressRequest addressRequest;

    public EmployeeRequest() {
    }

    public EmployeeRequest(Integer empId, String firstName, String lastName, String fatherName, Integer age, String email, Long mobileNumber, Double salary, AddressRequest addressRequest) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.age = age;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.salary = salary;
        this.addressRequest = addressRequest;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public AddressRequest getAddressRequest() {
        return addressRequest;
    }

    public void setAddressRequest(AddressRequest addressRequest) {
        this.addressRequest = addressRequest;
    }

    @Override
    public String toString() {
        return "EmployeeRequest{" +
                "empId=" + empId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", salary=" + salary +
                ", addressRequest=" + addressRequest +
                '}';
    }
}
