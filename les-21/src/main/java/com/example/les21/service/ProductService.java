package com.example.les21.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.les21.daoRepo.ProductRepo;
import com.example.les21.domain.Product;

@Service
public class ProductService {

	Logger logger = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	private ProductRepo productRepo;

	public Product saveProduct(Product product) {
		logger.info("Create new product");
		productRepo.save(product);
		return product;
	}

	public Iterable<Product> listOfProducts() {
		logger.info("Get all products");
		return productRepo.findAll();
	}

	public Product findById(Long id) {
		logger.info("Get product by id - " + id);
		return productRepo.findById(id).get();

	}
}
