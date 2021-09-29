package com.spring.professional.exam.tutorial.module03.question28.dao.custom;

import org.springframework.data.repository.CrudRepository;

import com.spring.professional.exam.tutorial.module03.question28.ds.Employee;

public interface CustomEmployeeDao extends CrudRepository<Employee, Integer>, CustomEmployeeDaoFindRepository {

}
