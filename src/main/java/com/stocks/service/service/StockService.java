package com.stocks.service.service;

import com.stocks.service.model.Stock;
import com.stocks.service.repository.*;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StockService {
    final private StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Collection<Stock> findAllStocks() {
        return stockRepository.findAll();
    }

    public Stock saveOrUpdateStock(Stock stock) {
        return stockRepository.saveAndFlush(stock);
    }

}
