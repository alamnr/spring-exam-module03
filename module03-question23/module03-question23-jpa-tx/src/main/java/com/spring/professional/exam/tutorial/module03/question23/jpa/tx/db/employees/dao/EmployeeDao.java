package com.spring.professional.exam.tutorial.module03.question23.jpa.tx.db.employees.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.professional.exam.tutorial.module03.question23.jpa.tx.db.employees.ds.Employee;

public interface EmployeeDao extends CrudRepository<Employee, Integer>{

}
