package com.example.les21.controllers;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.les21.domain.Product;
import com.example.les21.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/createProduct")
	public String createProduct() {
		return "createProductForm";
	}
	
	@PostMapping("/createProduct")
	public String createProductPost(@RequestParam(value = "image")MultipartFile file,@RequestParam String name,
			@RequestParam String description,@RequestParam Double price) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		String multipartFile = null;
		if (fileName.contains("..")) {
			System.out.println("file is not valid");
		}
		try {
		multipartFile=	Base64.getEncoder().encodeToString(file.getBytes());
		} catch ( IOException e) {
			e.printStackTrace();
		}
		Product product = new Product(name, multipartFile, description, price);
		productService.saveProduct(product);
		
		return "redirect:/index";
	}
}
