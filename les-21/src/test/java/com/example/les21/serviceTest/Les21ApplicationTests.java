package com.example.les21.serviceTest;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.les21.daoRepo.ProductRepo;
import com.example.les21.daoRepo.UserRepo;
import com.example.les21.domain.Product;
import com.example.les21.domain.User;
import com.example.les21.service.ProductService;
import com.example.les21.service.UserService;

@RunWith(SpringRunner.class)
@DataJpaTest
class Les21ApplicationTests {

	@Autowired
	private UserRepo userRepo;

	@Autowired(required = false)
	private UserService userService;
	@Autowired
	ProductRepo productRepo;
	@Autowired(required = false)
	ProductService productService;

	@Test
	void saveUserTest() {
		List<User> users = (List<User>) userRepo.findAll();

		User user = new User();
		user.setEmail("p@gmail.com");
		user.setFirstName("Oleh");
		user.setLastName("Popovich");
		user.setPassword("111");

		userRepo.save(user);

		users = (List<User>) userRepo.findAll();
		assertThat(users, hasSize(1));

		User user2 = users.get(0);
		assertTrue(user2.getEmail().equals(user.getEmail()));

	}

	@Test
	void userFindByEmail() {
		List<User> users = (List<User>) userRepo.findAll();

		User user = new User();
		user.setEmail("p@gmail.com");
		user.setFirstName("Oleh");
		user.setLastName("Popovich");
		user.setPassword("111");
		user.setRoles(null);
		userRepo.save(user);

		User user2 =userRepo.findByEmail("p@gmail.com");
		assertTrue(user2.getEmail().equals(user.getEmail()));

	}

	@Test
	void createProduct() {
		Iterable<Product> products = productRepo.findAll();

		Product product = new Product();
		product.setName("Movenpick");
		product.setImage("Image");
		product.setDescription("best");
		product.setPrice(25.1);

		productRepo.save(product);

		products = productRepo.findAll();
		assertThat((List<Product>) products, hasSize(1));
	}
	@Test
	void findByIdTest() {
		Iterable<Product> products = productRepo.findAll();

		Product product = new Product();
		product.setName("Movenpick");
		product.setImage("Image");
		product.setDescription("best");
		product.setPrice(25.1);

		productRepo.save(product);

		Product product2 = productRepo.findById((product.getId())).get();
		assertTrue(product.getName().equals(product2.getName()));
	}
	

}
