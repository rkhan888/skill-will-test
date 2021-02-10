package com.skillwilltest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class Student {

	@Id
	@GeneratedValue
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	
	public Student() {
	}

	public Student(int id, String firstName, String lastName, int age) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
		
}
