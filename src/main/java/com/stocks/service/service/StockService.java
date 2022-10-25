package com.stocks.service.service;

import com.stocks.service.repository.*;
import org.springframework.stereotype.Service;

@Service
public class StockService {
    final private BrandRepository brandRepository;
    final private CategoryRepository categoryRepository;
    final private ProductRepository productRepository;
    final private StockRepository stockRepository;
    final private StorageRepository storageRepository;

    public StockService(BrandRepository brandRepository,
                        CategoryRepository categoryRepository,
                        ProductRepository productRepository,
                        StockRepository stockRepository,
                        StorageRepository storageRepository)
    {
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.stockRepository = stockRepository;
        this.storageRepository = storageRepository;
    }

}
