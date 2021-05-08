package com.Sales.Sales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Sales.Sales.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>  {

}
