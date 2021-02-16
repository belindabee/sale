package com.glints.Assesment4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glints.Assesment4.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{
	public Product findById(int id);
}
