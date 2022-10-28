package com.stocks.service.service;

import com.stocks.service.model.Brand;
import com.stocks.service.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BrandService {
    final private BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public Collection<Brand> findAllBrands() {
        return brandRepository.findAll();
    }

    public Brand findBrandByName(String brandName) {
        return brandRepository.findBrandByBrandName(brandName);
    }

    public Brand saveOrUpdateBrand(Brand brand) {
        return brandRepository.saveAndFlush(brand);
    }
}
