package com.Sales.Sales.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Sales.Sales.dto.SaleSucessDTO;
import com.Sales.Sales.dto.SaleSumDTO;
import com.Sales.Sales.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>  {
	
	@Query("SELECT new com.Sales.Sales.dto.SaleSumDTO(obj.seller, SUM(obj.amount))"
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.Sales.Sales.dto.SaleSucessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals))"
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSucessDTO> sucessGroupedBySeller();
}
