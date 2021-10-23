package com.Sales.Sales.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Sales.Sales.dto.SaleDTO;
import com.Sales.Sales.dto.SaleSucessDTO;
import com.Sales.Sales.dto.SaleSumDTO;
import com.Sales.Sales.service.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService SaleService;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
		Page<SaleDTO> listSaleDTO = SaleService.findAll(pageable);
		
		return ResponseEntity.ok(listSaleDTO);
	}
	
	@GetMapping(value = "amount-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller(){
		List<SaleSumDTO> lisSaleSumDTO = SaleService.amountGroupedBySeller();
		
		return ResponseEntity.ok(lisSaleSumDTO);
	}
	
	@GetMapping(value = "sucess-by-seller")
	public ResponseEntity<List<SaleSucessDTO>> sucessGroupedBySeller(){
		List<SaleSucessDTO> listSaleSucessDTO = SaleService.sucessGroupedBySeller();
		
		return ResponseEntity.ok(listSaleSucessDTO);
	}
}
