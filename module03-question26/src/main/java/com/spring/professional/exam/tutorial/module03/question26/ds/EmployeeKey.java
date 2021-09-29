package com.spring.professional.exam.tutorial.module03.question26.ds;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Embeddable
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class EmployeeKey implements Serializable  {
	
	private String firstName;
	private String lastName;
	
	public EmployeeKey() {
	
	}

}
