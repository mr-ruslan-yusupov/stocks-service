package com.stocks.service;

import com.stocks.service.model.*;
import com.stocks.service.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class StocksServiceApplication implements CommandLineRunner {

	final private BrandService brandService;
	final private CategoryService categoryService;
	final private ProductService productService;
	final private StockService stockService;
	final private StorageService storageService;

	public StocksServiceApplication(
										BrandService brandService,
										CategoryService categoryService,
										ProductService productService,
										StockService stockService,
										StorageService storageService
									)
	{
		this.brandService = brandService;
		this.categoryService = categoryService;
		this.productService = productService;
		this.stockService = stockService;
		this.storageService = storageService;
	}

	public static void main(String[] args) {
		SpringApplication.run(StocksServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (brandService.findAllBrands().isEmpty()) {
			Brand brand1 = new Brand("HP");
			brandService.saveOrUpdateBrand(brand1);

			Brand brand2 = new Brand("Samsung");
			brandService.saveOrUpdateBrand(brand2);

			Brand brand3 = new Brand("Logitech");
			brandService.saveOrUpdateBrand(brand3);
		}

		if (categoryService.findAllCategories().isEmpty()) {
			Category category1 = new Category("Desktop Computers");
			categoryService.saveOrUpdateCategory(category1);

			Category category2 = new Category("Smartphones");
			categoryService.saveOrUpdateCategory(category2);

			Category category3 = new Category("Keyboards");
			categoryService.saveOrUpdateCategory(category3);
		}

		if (storageService.findAllStorages().isEmpty()) {
			Storage storage1 = new Storage("Storage Haifa","Haifa");
			storageService.saveOrUpdateStorage(storage1);

			Storage storage2 = new Storage("Storage Tel-aviv","Tel-aviv");
			storageService.saveOrUpdateStorage(storage2);

			Storage storage3 = new Storage("Storage Jerusalem","Jerusalem");
			storageService.saveOrUpdateStorage(storage3);
		}

		if (productService.findAllProducts().isEmpty()) {
			Product product = new Product();
			product.setCategory(categoryService.findCategoryByName("Desktop Computers"));
			product.setBrand(brandService.findBrandByName("HP"));
			product.setProductName("Desktop HP Pavilion Gaming TG01-2005nj");
			product.setProductDescription("מחשב נייח מבית HP בעל מעבד AMD Ryzen 7 5700G, זכרון בנפח 16GB, כונן קשיח מהיר בנפח 1TB SSD ומאיץ גרפי Nvidia GeForce RTX 3060Ti.");
			product.setCatalogNumber("HP-TG01-2005NJ");
			product.setProductPrice(BigDecimal.valueOf(5449));
			productService.saveOrUpdateProduct(product);
		}

		if (stockService.findAllStocks().isEmpty()) {
			Stock stock = new Stock();
			stock.setProduct(productService.findProductByCatalogNumber("HP-TG01-2005NJ"));
			stock.setStorage(storageService.findStorageByName("Storage Haifa"));
			stock.setQuantity(15);
			stockService.saveOrUpdateStock(stock);
		}

	}
}
