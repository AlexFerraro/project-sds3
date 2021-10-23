package com.Sales.Sales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Sales.Sales.dto.SaleDTO;
import com.Sales.Sales.dto.SaleSucessDTO;
import com.Sales.Sales.dto.SaleSumDTO;
import com.Sales.Sales.entities.Sale;
import com.Sales.Sales.repositories.SaleRepository;
import com.Sales.Sales.repositories.SallerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository saleRepository; 
	
	@Autowired
	private SallerRepository sellerRepository; 
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		//Executa o findALL() e guarda no cache do framework - Evita outras consultas na base para selecionar cada seller separadamente. Obs. Serve somente para tabelas com uma quantidade baixa de registros.
		sellerRepository.findAll();  
		Page<Sale> result = saleRepository.findAll(pageable);
			
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller()
	{	
		return saleRepository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSucessDTO> sucessGroupedBySeller()
	{	
		return saleRepository.sucessGroupedBySeller();
	}
}
