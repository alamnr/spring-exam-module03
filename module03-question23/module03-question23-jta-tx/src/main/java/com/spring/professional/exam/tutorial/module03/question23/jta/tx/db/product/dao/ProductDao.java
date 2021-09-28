package com.spring.professional.exam.tutorial.module03.question23.jta.tx.db.product.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.professional.exam.tutorial.module03.question23.jta.tx.db.product.ds.Product;

public interface ProductDao extends CrudRepository<Product, Integer> {

}
