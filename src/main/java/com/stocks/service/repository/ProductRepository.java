package com.stocks.service.repository;

import com.stocks.service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findProductByCatalogNumber(String catalogNumber);
}
