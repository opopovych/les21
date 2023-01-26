package com.example.les21.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.les21.daoRepo.ProductRepo;
import com.example.les21.domain.Product;

@Service
public class ProductService {
	@Autowired
	private ProductRepo productRepo;

	public Product saveProduct(Product product) {
		productRepo.save(product);
		return product;
	}

	public Iterable<Product> listOfProducts() {
		return productRepo.findAll();
	}
}
