package com.Sales.Sales.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sales.Sales.dto.SellerDTO;
import com.Sales.Sales.entities.Seller;
import com.Sales.Sales.repositories.SallerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SallerRepository sallerRepository; 
	
	public List<SellerDTO> findAll(){	
		List<Seller> result = sallerRepository.findAll();
		
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}
}
