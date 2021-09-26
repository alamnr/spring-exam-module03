package com.spring.professional.exam.tutorial.module03.question22.service;

import java.sql.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.professional.exam.tutorial.module03.question22.ds.Employee;
import com.spring.professional.exam.tutorial.module03.question22.dao.JdbcEmployeeDao;
import com.spring.professional.exam.tutorial.module03.question22.dao.JpaEmployeeDao;

@Service
public class EmployeeService {

	@Autowired
	private JpaEmployeeDao jpaEmployeeDao;
	
	@Autowired
	private JdbcEmployeeDao jdbcEmployeeDao;
	
	@Transactional
	public void saveEmployeesUnderOneTransaction() {
		System.out.println("Saving all employees ... ");
		
		System.out.println("Saving employee with JPA ...");
		Employee savedEmployee = jpaEmployeeDao.save(new Employee(1, "John", "Doe", "John.Doe@corp.com", "555-55-55", Date.valueOf("2019-06-05"), 70000));
		if(savedEmployee.getId() != null) {
			System.out.println("Saved employee --- [1] ");
		}
		
		System.out.println("Saved employee with JPA. ");
		
		System.out.println("Saving employee with JDBC ... ");
		jdbcEmployeeDao.saveEmployee(new Employee(2, "Willow", "Zhang", "Willow.Zhang@corp.com", "555-55-56", Date.valueOf("2019-07-12"), 80000));
		System.out.println("Saved employee with JDBC");
		
		
		
		System.out.println("Saved all employees");
	}
	
	@Transactional
	public void listAllEmployees() {
		System.out.println("Listing all employees ...");
		
		jpaEmployeeDao.findAll().forEach(System.out::println);
	}
}
