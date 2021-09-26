package com.spring.professional.exam.tutorial.module03.question22.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.professional.exam.tutorial.module03.question22.ds.Employee;

public interface JpaEmployeeDao extends CrudRepository<Employee, Integer> {

}
