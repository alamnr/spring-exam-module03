package com.spring.professional.exam.tutorial.module03.question23.jta.tx.db.employee.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.professional.exam.tutorial.module03.question23.jta.tx.db.employee.ds.Employee;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {

}
