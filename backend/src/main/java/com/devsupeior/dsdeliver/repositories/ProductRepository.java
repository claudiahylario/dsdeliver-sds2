package com.devsupeior.dsdeliver.repositories;

import java.util.List;

import com.devsupeior.dsdeliver.entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
    List<Product> findAllByOrderByNameAsc();
}
