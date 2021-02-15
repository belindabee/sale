package com.glints.Assesment4.controler;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glints.Assesment4.model.Supplier;
import com.glints.Assesment4.payload.SupplierPayload;
import com.glints.Assesment4.service.SupplierService;

	@RestController
	@RequestMapping("/api")
	public class SupplierController {

		@Autowired
		SupplierService supplierService;
		
		@GetMapping("/supplier")
		public ResponseEntity<List<Supplier>> read(){
			List<Supplier> suppliers = supplierService.read();
			return new ResponseEntity<List<Supplier>>(suppliers, HttpStatus.OK);
		}
		
		@PostMapping("/create-supplier")
		public ResponseEntity<Supplier> create(@Valid @RequestBody SupplierPayload supplierPayload){
			Supplier supplier = supplierService.create(supplierPayload);
			return new ResponseEntity<Supplier>(supplier, HttpStatus.OK);
		}	
			
		@DeleteMapping("/delete-supplier/{id}")
		public String delete(@PathVariable("id") Integer id) {
			supplierService.delete(id);
			return "Supplier with id: " + id + " has been deleted!";
		}
		
		@GetMapping("/supplier/{id}")
		public ResponseEntity<Supplier> readById(@PathVariable("id") Integer id){
			Supplier supplier = supplierService.readById(id);
			return new ResponseEntity<Supplier>(supplier, HttpStatus.OK);
		}
		
}
