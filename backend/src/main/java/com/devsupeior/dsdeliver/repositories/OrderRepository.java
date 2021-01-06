package com.devsupeior.dsdeliver.repositories;

import com.devsupeior.dsdeliver.entities.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
