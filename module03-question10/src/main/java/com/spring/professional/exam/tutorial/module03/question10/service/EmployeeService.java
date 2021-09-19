package com.spring.professional.exam.tutorial.module03.question10.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.professional.exam.tutorial.module03.question10.dao.EmployeeDao;
import com.spring.professional.exam.tutorial.module03.question10.ds.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	public void printEmployee() {
		System.out.println("Printing list of employees");
		employeeDao.findAllEmployees().forEach(System.out::println);
	}
	
	public void deleteAllEmployee() {
		System.out.println("Deleting All Employees ...");
		employeeDao.deleteAllEmployees();
	}
	
	public void saveEmployeeWithoutTransaction() {
		System.out.println("Saving Employees without transaction ...");
		saveEmployees();
	}
	
	@Transactional
	public void saveEmployeesInTransaction() {
		System.out.println("Saving employee with transaction");
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
