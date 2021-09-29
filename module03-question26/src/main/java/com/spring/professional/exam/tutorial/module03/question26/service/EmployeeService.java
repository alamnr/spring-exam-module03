package com.spring.professional.exam.tutorial.module03.question26.service;

import java.sql.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.professional.exam.tutorial.module03.question26.dao.EmployeDao;
import com.spring.professional.exam.tutorial.module03.question26.ds.Employee;
import com.spring.professional.exam.tutorial.module03.question26.ds.EmployeeKey;

@Service
public class EmployeeService {

	@Autowired
	private EmployeDao employeeDao;
	
	//@Transactional
	public void saveEmployee() {
        System.out.println("Saving employee...");

        employeeDao.save(new Employee(new EmployeeKey("John", "Doe"), "John.Doe@corp.com", "555-55-55", Date.valueOf("2019-06-05"), 70000));

        System.out.println("Employee saved");
        
        //System.out.println("Throwing unchecked exception to rollback while method is annotated with @Transactional annotation ....");
        //throw new IllegalArgumentException();
    }

    public void listEmployee() {
        System.out.println("Searching for John Doe employee...");
        employeeDao.findById(new EmployeeKey("John", "Doe")).ifPresent(System.out::println);
    }
}
