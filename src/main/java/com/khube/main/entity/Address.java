package com.khube.main.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;

@Entity
@Table(name = "address_tab")
public class Address {

	@Id
	private Integer addressId;
	private String street;
	private String line1;
	private String line2;
	private String markedLocation;
	private String city;
	private Integer pinCode;
	private String state;
	private String country;
	private Integer empId;

	public Address() {
	}

	public Address(Integer addressId, String street, String line1, String line2, String markedLocation, String city,
			Integer pinCode, String state, String country, Integer empId) {
		this.addressId = addressId;
		this.street = street;
		this.line1 = line1;
		this.line2 = line2;
		this.markedLocation = markedLocation;
		this.city = city;
		this.pinCode = pinCode;
		this.state = state;
		this.country = country;
		this.empId = empId;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getMarkedLocation() {
		return markedLocation;
	}

	public void setMarkedLocation(String markedLocation) {
		this.markedLocation = markedLocation;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + ", line1=" + line1 + ", line2=" + line2
				+ ", markedLocation=" + markedLocation + ", city=" + city + ", pinCode=" + pinCode + ", state=" + state
				+ ", country=" + country + ", empId=" + empId + "]";
	}
}
