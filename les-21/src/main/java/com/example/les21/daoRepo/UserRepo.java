package com.example.les21.daoRepo;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
	List<User> findByEmail(String email);
}
