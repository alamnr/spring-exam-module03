package com.spring.professional.exam.tutorial.module03.question23.jpa.tx.db.products.ds;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "price")
	private float price;
	@Column(name = "available")
	private boolean available;
	
	public Product() {
		
	}
}
