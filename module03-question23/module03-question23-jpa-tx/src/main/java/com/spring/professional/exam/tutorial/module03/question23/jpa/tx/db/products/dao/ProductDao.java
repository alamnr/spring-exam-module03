package com.spring.professional.exam.tutorial.module03.question23.jpa.tx.db.products.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.professional.exam.tutorial.module03.question23.jpa.tx.db.products.ds.Product;

public interface ProductDao extends CrudRepository<Product, Integer> {

}
