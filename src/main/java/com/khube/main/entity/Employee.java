package com.khube.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;

@Entity
@Table(name = "employee_tab")
public class Employee {

    @Id
    private Integer empId;
    private String firstName;
    private String lastName;
    private String fatherName;
    private Integer age;
    private String email;
    private Long mobileNumber;
    private Double salary;

    public Employee() {
    }
    public Employee(Integer empId, String firstName, String lastName, String fatherName, Integer age, String email, Long mobileNumber, Double salary) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.age = age;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.salary = salary;
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

    @Override
    public String toString() {
        return "EmployeeResponse{" +
                "empId=" + empId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", salary=" + salary +
                '}';
    }
}
