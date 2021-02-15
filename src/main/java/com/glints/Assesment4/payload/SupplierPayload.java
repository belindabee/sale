package com.glints.Assesment4.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class SupplierPayload {	
	@NotBlank(message = "Name is required!")
	@Size(min=3, message = "Name min 3 characters!")
	private String name;
	
	@NotBlank(message = "Address is required!")
	@Size(min=3, message = "Address min 3 character")
	private String address;
	
	@NotBlank(message = "Contact is require")
	private long contact;
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public long getContact() {
		return contact;
	}
}
