package com.devsupeior.dsdeliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import com.devsupeior.dsdeliver.dto.OrderDTO;
import com.devsupeior.dsdeliver.dto.ProductDTO;
import com.devsupeior.dsdeliver.entities.Order;
import com.devsupeior.dsdeliver.entities.OrderStatus;
import com.devsupeior.dsdeliver.entities.Product;
import com.devsupeior.dsdeliver.repositories.OrderRepository;
import com.devsupeior.dsdeliver.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductRepository ProductRepository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll() {
        List<Order> list = repository.findOrderWithProducts();
        return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public OrderDTO insert(OrderDTO dto){
        Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(), 
        Instant.now(), OrderStatus.PENDING);

        for(ProductDTO p : dto.getProducts()){
            Product product = ProductRepository.getOne(p.getId());
            order.getProducts().add(product);
        }
        order = repository.save(order);
        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO SetDelivered(Long id){
        Order order = repository.getOne(id);
        order.setStatus(OrderStatus.DELIVERED);
        order = repository.save(order);
        return new OrderDTO(order);
    }
}
