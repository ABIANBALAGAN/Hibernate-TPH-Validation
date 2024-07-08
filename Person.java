package com.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name="PERSONDATA101")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="category",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="general")
public class Person {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
    @NotNull(message="Invalid ID.Please enter your ID.")
	int id;
   @NotNull(message = "Name cannot be null")
   @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
	String name;
   
   @NotNull(message = "Address cannot be null")
   @Size(min = 4, max = 50, message = "Address must be between 8 and 50 characters")
	String address;
	

	public Person() {
		super();
	}
	

	public Person(String name) {
		super();
		this.name = name;
		
	}





	public Person(String name,String address) {
		super();
	
		this.name = name;
		this.address=address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
