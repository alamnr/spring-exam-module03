package com.spring.professional.exam.tutorial.module03.question23.jta.tx.service;



import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.professional.exam.tutorial.module03.question23.jta.tx.db.employee.dao.EmployeeDao;
import com.spring.professional.exam.tutorial.module03.question23.jta.tx.db.employee.ds.Employee;
import com.spring.professional.exam.tutorial.module03.question23.jta.tx.db.product.dao.ProductDao;
import com.spring.professional.exam.tutorial.module03.question23.jta.tx.db.product.ds.Product;

@Service
public class WareHouseService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Transactional
	public void purgeData() {
		employeeDao.deleteAll();
		productDao.deleteAll();
	}
	
	@Transactional
	public void saveData() {
		System.out.println("Saving Employee 1 ... ");
		Employee e = employeeDao.save(new Employee(null, "John", "Doe", "John.Doe@corp.com", "555-55-55", Date.valueOf("2019-06-05"), 70000));
		System.out.println("Saved employee 1");
		
		System.out.println("Saving Product 1 ...");
		Product p = productDao.save(new Product(null, "Jet Ski", 20, 4799f, true));
		System.out.println("Saved Product 1");
		
		System.out.println("Throwing exception to revert transaction");
        throw new IllegalArgumentException();
	}
	
	@Transactional
	public void listAllData() {
		System.out.println("Listing all employees ... ");
		employeeDao.findAll().forEach(System.out::println);
		
		System.out.println("Listing all products .... ");
		productDao.findAll().forEach(System.out::println);
	}
}
