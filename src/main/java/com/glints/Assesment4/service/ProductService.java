package com.glints.Assesment4.service;

import java.util.List;

import com.glints.Assesment4.model.Product;
import com.glints.Assesment4.payload.ProductPayload;


public interface ProductService {
	public List<Product> read();
	public Product create(ProductPayload productPayload);
	public String delete(Integer id);
	public Product readById(Integer id);
}
