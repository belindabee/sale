package com.glints.Assesment4.payload;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.glints.Assesment4.model.Product;

import lombok.Data;

@Data
public class ProductPayload {

	@NotBlank(message = "Product name is required!")
	@Size(min=3, message = "Product name min 3 Characters!")
	private String ProductName;
	
	@NotNull(message = "price is required")
	private Integer price;
	
	@NotNull(message = "Product status is required!")
	private Product.ProductStatus productStatus;
	
	@Min(1)
	private Integer supplierid;
	
	public String getProductName() {
		return ProductName;
	}
	public Integer getPrice() {
		return price;
	}
	public Integer getQuantity(quantity) {
		return quantity;
	}
}
