package com.glints.Assesment4.service;

import java.util.List;

import com.glints.Assesment4.model.Sale;
import com.glints.Assesment4.payload.SalePayload;


public interface SaleService {
	public List<Sale> read();
	public Sale create(SalePayload salePayload);
	public String delete(Integer id);
	public Sale readById(Integer id);
}
