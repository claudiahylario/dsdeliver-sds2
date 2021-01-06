package com.devsupeior.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import com.devsupeior.dsdeliver.dto.OrderDTO;
import com.devsupeior.dsdeliver.entities.Order;
import com.devsupeior.dsdeliver.repositories.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;
    @Transactional(readOnly = true)
    public List<OrderDTO> findAll() {
        List<Order> list = repository.findOrderWithProducts();
        return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
    }
}
