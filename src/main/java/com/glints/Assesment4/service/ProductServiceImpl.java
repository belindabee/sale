package com.glints.Assesment4.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glints.Assesment4.model.Product;
import com.glints.Assesment4.model.Supplier;
import com.glints.Assesment4.payload.ProductPayload;
import com.glints.Assesment4.repository.ProductRepo;
import com.glints.Assesment4.repository.SupplierRepo;


@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	SupplierRepo supplierRepo;

	@Override
	public List<Product> read() {
		List<Product> products = productRepo.findAll();
		return products;
	}

	@Override
	public Product create(ProductPayload productPayload) {
		Supplier supplier = supplierRepo.findById(productPayload.getSupplierId()).orElse(null);
		Product product = new Product(productPayload.getProductName(),
								productPayload.getPrice(),
								productPayload.getQuantity(),
								productPayload.getProductStatu(),
								supplier
							);
		product = productRepo.save(product);
		return product;
	}
	@Override
	public Product update(Integer id, ProductPayload productPayload) {
		Supplier supplier = supplierRepo.findById(id).orElse(null);
		Product product = productRepo.findById(id).orElseThrow(() -> new BadRequestException("Product with id: " + id + " not found!"));
		product.setProductName(productPayload.getProductName());
		product.setPrice(price);(productPayload.getPrice());
		product.setQuantity(productPayload.getQuantity());
		product.setProductStatus(productPayload.getProductStatus());
		product.setUpdatedTime(new Date());
		product.setSupplier(supplier);
		product = productRepo.save(product);
		return product;
	}

	@Override
	public String delete(Integer id) {
		productRepo.deleteById(id);
		return "Product with id: " + id + " has been deleted!";
	}

	@Override
	public Product readById(Integer id) {
		Product product = productRepo.findById(id).orElse(null);
		return product;
	}
	
}
