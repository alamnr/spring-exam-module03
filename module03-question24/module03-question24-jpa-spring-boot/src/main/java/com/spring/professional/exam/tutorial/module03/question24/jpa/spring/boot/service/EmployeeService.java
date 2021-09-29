package com.spring.professional.exam.tutorial.module03.question24.jpa.spring.boot.service;

import java.sql.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.professional.exam.tutorial.module03.question24.jpa.spring.boot.dao.EmployeeDao;
import com.spring.professional.exam.tutorial.module03.question24.jpa.spring.boot.ds.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Transactional
	public void saveAllEmployees() {
		 System.out.println("Saving all employees...");

	        employeeDao.save(new Employee(1, "John", "Doe", "John.Doe@corp.com", "555-55-55", Date.valueOf("2019-06-05"), 70000));
	        employeeDao.save(new Employee(2, "Willow", "Zhang", "Willow.Zhang@corp.com", "555-55-56", Date.valueOf("2019-07-12"), 80000));
	        employeeDao.save(new Employee(3, "Jayvon", "Grant", "Jayvon.Grant@corp.com", "555-55-57", Date.valueOf("2019-07-17"), 90000));
	        employeeDao.save(new Employee(4, "Shaylee", "Mcclure", "Shaylee.Mcclure@corp.com", "555-55-58", Date.valueOf("2019-07-19"), 120000));
	        employeeDao.save(new Employee(5, "Miley", "Krueger", "Miley.Krueger@corp.com", "555-55-59", Date.valueOf("2019-07-20"), 110000));

	        System.out.println("Saved all employees");
	        
	        System.out.println("Thowing unchecked exception to test @Transactional annotation... ");
	        throw new IllegalArgumentException();
	}
	
	public void listAllemployees() {
		System.out.println("Listing employees ... ");
		
		employeeDao.findAll().forEach(System.out::println);
	}
}
