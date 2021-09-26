package com.spring.professional.exam.tutorial.module03.question22.ds;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Employee {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_id")
	private Integer id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email")
	private String email;
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column(name = "hire_date")
	private Date hireDate;
	@Column(name = "salary")
	private float salary;
	
	public Employee() {
	
	}
}
