package com.spring.professional.exam.tutorial.module03.question24.jpa.spring.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.professional.exam.tutorial.module03.question24.jpa.spring.ds.Employee;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {

}
