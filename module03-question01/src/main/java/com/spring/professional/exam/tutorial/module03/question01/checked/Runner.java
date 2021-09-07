package com.spring.professional.exam.tutorial.module03.question01.checked;

import com.spring.professional.exam.tutorial.module03.question01.checked.dao.PersonDao;
import com.spring.professional.exam.tutorial.module03.question01.checked.ds.Person;
import com.spring.professional.exam.tutorial.module03.question01.checked.exception.DaoFileSystemException;
import com.spring.professional.exam.tutorial.module03.question01.checked.exception.PersonInvalidException;
import com.spring.professional.exam.tutorial.module03.question01.checked.exception.PersonStoreException;

public class Runner {
	
	public static void main(String[] args)  {
		PersonDao personDao = new PersonDao();
		Person person = new Person();
		
		try {
			personDao.save(person);
		} catch (PersonInvalidException | DaoFileSystemException | PersonStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		try {
			personDao.save(person);
		} catch (PersonInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DaoFileSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PersonStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
	}

}
