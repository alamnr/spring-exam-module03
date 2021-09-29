package com.spring.professional.exam.tutorial.module03.question24.jpa.spring.boot.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.professional.exam.tutorial.module03.question24.jpa.spring.boot.ds.Employee;

public interface EmployeeDao extends CrudRepository<Employee, Integer>{

}
