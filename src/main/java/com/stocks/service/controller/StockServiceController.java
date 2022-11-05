package com.stocks.service.controller;

import com.stocks.service.service.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockServiceController {
    final private BrandService brandService;
    final private CategoryService categoryService;
    final private StorageService storageService;
    final private ProductService productService;
    final private StockService stockService;

    @Value("${application.name}")
    private String applicationName;

    @Value("${build.version}")
    private String buildVersion;

    @Value("${build.timestamp}")
    private String buildTimestamp;

    public StockServiceController(BrandService brandService,
                                  CategoryService categoryService,
                                  StorageService storageService,
                                  ProductService productService,
                                  StockService stockService)
    {
        this.brandService = brandService;
        this.categoryService = categoryService;
        this.storageService = storageService;
        this.productService = productService;
        this.stockService = stockService;
    }

    @RequestMapping(value = {"/","/stock"}, produces = MediaType.TEXT_PLAIN_VALUE)
    public String home() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n[Application info]");
        sb.append("\nApplication name : " + applicationName);
        sb.append("\nBuild version    : " + buildVersion);
        sb.append("\nBuild timestamp  : " + buildTimestamp);
        return sb.toString();
    }


}
