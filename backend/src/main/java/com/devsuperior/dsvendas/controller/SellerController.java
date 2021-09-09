package com.devsuperior.dsvendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.devsuperior.dsvendas.dto.SellerDto;
import com.devsuperior.dsvendas.services.SellerService;

@RestControllerAdvice
@RequestMapping
public class SellerController {

	@Autowired
	private SellerService sellerService;
	
	@GetMapping(value = "/sellers")
	public ResponseEntity<List<SellerDto>> findAll(){
		
		List<SellerDto> list = sellerService.findAll();
		return ResponseEntity.ok(list);
	}
	
}
