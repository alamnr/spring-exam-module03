package com.spring.professional.exam.tutorial.module03.question26.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.professional.exam.tutorial.module03.question26.ds.Employee;
import com.spring.professional.exam.tutorial.module03.question26.ds.EmployeeKey;

public interface EmployeDao  extends CrudRepository<Employee, EmployeeKey> {

}
