package com.devsupeior.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import com.devsupeior.dsdeliver.dto.ProductDTO;
import com.devsupeior.dsdeliver.entities.Product;
import com.devsupeior.dsdeliver.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;
    @Transactional(readOnly = true)
    public List<ProductDTO> findAll() {
        List<Product> list = repository.findAllByOrderByNameAsc();
        return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
    }
}
