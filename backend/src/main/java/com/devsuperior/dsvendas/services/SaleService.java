package com.devsuperior.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDto;
import com.devsuperior.dsvendas.dto.SaleSuccessDto;
import com.devsuperior.dsvendas.dto.SaleSumDto;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository saleRepository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true) //toda a operação de transação será resolvida sem dar lock em banco
	public Page<SaleDto> findAll(Pageable pageable){
		
		sellerRepository.findAll(); //salvar os vendedores em memória
	
		Page<Sale> result = saleRepository.findAll(pageable);
		
		// stream.map - converte colections de um tipo para outro
		// lambda => casa item da lista (x) é comvertido de List<Seller> para List<SellerDto>
		return result.map(x -> new SaleDto(x)); 
	}
	
	
	@Transactional(readOnly = true)
	public List<SaleSumDto> amountGroupedBySeller(){
		
		return saleRepository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDto> successGroupedBySeller(){
		
		return saleRepository.successGroupedBySeller();
	}

}
