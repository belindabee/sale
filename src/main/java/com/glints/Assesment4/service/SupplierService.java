package com.glints.Assesment4.service;

import java.util.List;

import com.glints.Assesment4.model.Supplier;
import com.glints.Assesment4.payload.SupplierPayload;

public interface SupplierService {
	public List<Supplier> read();
	public Supplier create(SupplierPayload supplierPayload);
	public Supplier update(Integer id, SupplierPayload supplierPayload);
	public String delete(Integer id);
	public Supplier readById(Integer id);
}
