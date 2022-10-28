package com.stocks.service.repository;

import com.stocks.service.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Long> {
    Brand findBrandByBrandName(String brandName);
}
