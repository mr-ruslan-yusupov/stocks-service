package com.stocks.service.controller;

import com.stocks.service.service.StockService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockServiceController {
    final private StockService stockService;

    public StockServiceController(StockService stockService) {
        this.stockService = stockService;
    }

}
