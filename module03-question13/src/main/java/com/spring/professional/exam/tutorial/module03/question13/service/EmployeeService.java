package com.spring.professional.exam.tutorial.module03.question13.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.professional.exam.tutorial.module03.question13.dao.EmployeeDao;
import com.spring.professional.exam.tutorial.module03.question13.ds.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	public void printEmployees() {
		System.out.println("Printing list of employees.");
		employeeDao.findAllEmployees().forEach(System.out::println);
	}
	
	public void deleteAllEmployee() {
		System.out.println("Deleting all employees.");
		employeeDao.deleteAllEmployees();
	}
	
	public void saveEmployeeWithoutTransaction() {
		System.out.println("Saving employee without transaction ...");
		saveEmployees();
	}
	
	@Transactional
	public void saveEmployeeInTransaction() {
		System.out.println("Saving employee in transaction ... ");
		saveEmployees();
	}
	
	private void saveEmployees() {
		 employeeDao.saveEmployee(new Employee(1, "John", "Doe", "John.Doe@corp.com", "555-55-55", Date.valueOf("2019-06-05"), 70000));
	        employeeDao.saveEmployee(new Employee(2, "Willow", "Zhang", "Willow.Zhang@corp.com", "555-55-56", Date.valueOf("2019-07-12"), 80000));
	        employeeDao.saveEmployee(new Employee(3, "Jayvon", "Grant", "Jayvon.Grant@corp.com", "555-55-57", Date.valueOf("2019-07-17"), 90000));
	        employeeDao.saveEmployee(new Employee(-1, "Shaylee", "Mcclure", "Shaylee.Mcclure@corp.com", "555-55-58", Date.valueOf("2019-07-19"), 120000));
	        employeeDao.saveEmployee(new Employee(5, "Miley", "Krueger", "Miley.Krueger@corp.com", "555-55-59", Date.valueOf("2019-07-20"), 110000));
	}
}
