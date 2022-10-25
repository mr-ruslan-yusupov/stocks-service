package com.stocks.service.repository;

import com.stocks.service.model.Stock;
import com.stocks.service.model.StockCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, StockCompositeKey> {
}
