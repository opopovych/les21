package com.example.les21.controllers;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.les21.domain.Bucket;
import com.example.les21.domain.Product;
import com.example.les21.domain.User;
import com.example.les21.service.BucketService;
import com.example.les21.service.ProductService;
import com.example.les21.service.UserService;

@Controller
public class BucketController {
	@Autowired
	BucketService bucketService;
	@Autowired
	ProductService productService;
	@Autowired
	UserService userService;

	@GetMapping("/bucket")
	public String showBucket(Model model) {

		model.addAttribute("bucket", bucketService.getAll());
		return "bucket";
	}

	@PostMapping("/bucket")
	public String create(Model model, @RequestParam String id) {
		Product product = productService.findById(Long.parseLong(id));
		Bucket bucket = new Bucket();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userEmail = authentication.getName();
		User user = userService.findUserByEmail(userEmail);
bucket.setProduct(product);
bucket.setUser(user);
		bucketService.add(bucket);

		model.addAttribute("bucket", bucketService.getAll());
		return "bucket";
	}

	@GetMapping("/{id}/delete")
	public String delete(@PathVariable(value = "id") String id, Model model) {
		bucketService.delete(new Bucket(Long.parseLong(id)));
		model.addAttribute("bucket", bucketService.getAll());

		return "bucket";
	}
}
