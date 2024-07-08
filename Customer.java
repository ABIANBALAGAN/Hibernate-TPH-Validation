package com.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value="customer")
public class Customer extends Person {
	@Email(message="Invalid email address.Please enter a proper MailId")
	@NotNull(message="Please enter your email id")
	String email;
	
	@Digits(integer=10,fraction=0,message="Invalid mobile.Maximum valid number is 10")
	long mobile;
	
	 @NotNull(message = "CustomerType cannot be null")
	 @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
	 String customertype;
	public Customer() {
		super();
	}
	public Customer(String name,String email, long mobile, String customertype,String address) {
		super(name,address);
		this.name=name;
		this.email = email;
		this.mobile = mobile;
		this.customertype = customertype;
		//this.address=address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getCustomertype() {
		return customertype;
	}
	public void setCustomertype(String customertype) {
		this.customertype = customertype;
	}
	

}