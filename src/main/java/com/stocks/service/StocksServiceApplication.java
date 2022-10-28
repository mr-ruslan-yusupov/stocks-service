package com.stocks.service;

import com.stocks.service.model.Brand;
import com.stocks.service.model.Category;
import com.stocks.service.model.Product;
import com.stocks.service.model.Storage;
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
		if (brandService.findAll().isEmpty()) {
			Brand brand1 = new Brand("HP");
			brandService.saveOrUpdate(brand1);

			Brand brand2 = new Brand("Samsung");
			brandService.saveOrUpdate(brand2);

			Brand brand3 = new Brand("Logitech");
			brandService.saveOrUpdate(brand3);
		}

		if (categoryService.findAll().isEmpty()) {
			Category category1 = new Category("Desktop Computers");
			categoryService.saveOrUpdate(category1);

			Category category2 = new Category("Smartphones");
			categoryService.saveOrUpdate(category2);

			Category category3 = new Category("Keyboards");
			categoryService.saveOrUpdate(category3);
		}

		if (storageService.findAll().isEmpty()) {
			Storage storage1 = new Storage("Storage Haifa","Haifa");
			storageService.saveOrUpdate(storage1);

			Storage storage2 = new Storage("Storage Tel-aviv","Tel-aviv");
			storageService.saveOrUpdate(storage2);

			Storage storage3 = new Storage("Storage Jerusalem","Jerusalem");
			storageService.saveOrUpdate(storage3);
		}

//		Product product = new Product();
//		product.setCategory(catComputerDesktop);
//		product.setBrand(brandHP);
//		product.setProductName("Desktop HP Pavilion Gaming TG01-2005nj");
//		product.setProductDescription("מחשב נייח מבית HP בעל מעבד AMD Ryzen 7 5700G, זכרון בנפח 16GB, כונן קשיח מהיר בנפח 1TB SSD ומאיץ גרפי Nvidia GeForce RTX 3060Ti.");
//		product.setProductPrice(BigDecimal.valueOf(5449));

		//stockService.saveOrUpdateProduct(product);
	}
}
