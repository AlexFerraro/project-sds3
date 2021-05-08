package com.Sales.Sales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Sales.Sales.entities.Seller;

public interface SallerRepository extends JpaRepository<Seller, Long>  {

}
