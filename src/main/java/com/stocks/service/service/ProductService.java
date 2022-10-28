package com.stocks.service.service;

import com.stocks.service.model.Product;
import com.stocks.service.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductService {
    final private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Collection<Product> findAll() {
        return productRepository.findAll();
    }

    public Product saveOrUpdate(Product product) {
        return productRepository.saveAndFlush(product);
    }
}
