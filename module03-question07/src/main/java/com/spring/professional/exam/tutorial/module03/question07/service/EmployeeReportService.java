package com.spring.professional.exam.tutorial.module03.question07.service;
import static com.spring.professional.exam.tutorial.module03.question07.util.SqlRowSetUtil.SqlRowSetToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.professional.exam.tutorial.module03.question07.dao.EmployeeDao;

@Service
public class EmployeeReportService {

	@Autowired
	private EmployeeDao employeeDao;
	
	public void printReportCount() {
		System.out.println("Starting print employee count ");
		System.out.println("Employee count - "+employeeDao.getNumberOfEmployees());
		System.out.println("findEmployeeEmail(1)");
        System.out.println(employeeDao.findEmployeeEmail(1));

        System.out.println("findEmployeesNames()");
        employeeDao.findEmployeesNames().forEach(System.out::println);

        System.out.println("findEmployeeById(2)");
        System.out.println(employeeDao.findEmployeeById(2));

        System.out.println("findEmployeesRowSet()");
        System.out.println(SqlRowSetToString(employeeDao.findEmployeesRowSet()));

        System.out.println("findEmployee(3)");
        System.out.println(employeeDao.findEmployee(2));

        System.out.println("findAllEmployees()");
        System.out.println(employeeDao.findAllEmployees());

        System.out.println("Employee Report Stop");
    }

}
