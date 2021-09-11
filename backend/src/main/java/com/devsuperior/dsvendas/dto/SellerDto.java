package com.devsuperior.dsvendas.dto;

import java.io.Serializable;

import com.devsuperior.dsvendas.entities.Seller;

public class SellerDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String name;
	
	public SellerDto() {
		
	}
	
	public SellerDto(long id, String name) {
		this.id = id;
		this.name = name;
	}

	

	public SellerDto(Seller entity) {
		id = entity.getId();
		name = entity.getName();
	}


	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	
}
