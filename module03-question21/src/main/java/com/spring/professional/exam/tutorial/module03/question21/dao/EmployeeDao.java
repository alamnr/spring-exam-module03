package com.spring.professional.exam.tutorial.module03.question21.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.professional.exam.tutorial.module03.question21.ds.Employee;

public interface  EmployeeDao extends CrudRepository<Employee, Integer>  {

}
