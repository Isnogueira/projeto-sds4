package com.devsuperior.dsvendas.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.entities.Seller;


public class SaleDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long id;
	private Integer visited;
	private Integer deals;
	private float amount;
	private LocalDate date;
	
	private SellerDto seller;
	
	
	public SaleDto() {
	}


	public SaleDto(long id, Integer visited, Integer deals, float amount, LocalDate date) {
		this.id = id;
		this.visited = visited;
		this.deals = deals;
		this.amount = amount;
		this.date = date;
	}

	public SaleDto(Sale entity) {
		id = entity.getId();
		visited = entity.getVisited();
		deals = entity.getDeals();
		amount = entity.getAmount();
		date = entity.getDate();
		seller = new SellerDto(entity.getSeller());
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Integer getVisited() {
		return visited;
	}


	public void setVisited(Integer visited) {
		this.visited = visited;
	}


	public Integer getDeals() {
		return deals;
	}


	public void setDeals(Integer deals) {
		this.deals = deals;
	}


	public float getAmount() {
		return amount;
	}


	public void setAmount(float amount) {
		this.amount = amount;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public SellerDto getSeller() {
		return seller;
	}


	public void setSeller(SellerDto seller) {
		this.seller = seller;
	}
	
	
}
