package com.spring.professional.exam.tutorial.module03.question26.ds;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Employee {
	
	@EmbeddedId
	private EmployeeKey employeeKey;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private float salary;
	
	public Employee() {
	
	}
	

}
