package com.example.les21.daoRepo;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.les21.domain.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
	List<User> findByEmail(String email);
}
