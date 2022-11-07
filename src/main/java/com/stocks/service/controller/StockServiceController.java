package com.stocks.service.controller;

import com.stocks.service.model.Brand;
import com.stocks.service.service.*;
import com.store.util.StoreConstants;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(value = {"/","/stocks-service"}, produces = MediaType.TEXT_PLAIN_VALUE)
    public String home() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n[Application info]");
        sb.append("\nApplication name : " + applicationName);
        sb.append("\nBuild version    : " + buildVersion);
        sb.append("\nBuild timestamp  : " + buildTimestamp);
        return sb.toString();
    }

    @PostMapping(value = "/stocks-service/brand/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addBrand(@RequestBody Brand brand) {
        JSONObject jsonObject = new JSONObject();
        try {
            Brand savedBrand = brandService.saveOrUpdateBrand(brand);
            jsonObject.put("status", StoreConstants.SUCCESS_STATUS);
            jsonObject.put("message", "Brand " + savedBrand.getBrandName() + " saved successfully");
            return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);
        } catch (JSONException e) {
            try {
                jsonObject.put("status", StoreConstants.FAILURE_STATUS);
                jsonObject.put("exception", e.getMessage());
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
            return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.OK);
        }
    }

}
