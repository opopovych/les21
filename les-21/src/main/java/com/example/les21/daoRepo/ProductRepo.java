package com.example.les21.daoRepo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.les21.domain.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {

}
