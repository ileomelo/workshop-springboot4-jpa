package com.core.webserviceSpring.services;

import com.core.webserviceSpring.entities.Product;
import com.core.webserviceSpring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product Not Found with id: " + id));
    }
}
