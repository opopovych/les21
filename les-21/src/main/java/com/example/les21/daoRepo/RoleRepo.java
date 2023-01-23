package com.example.les21.daoRepo;

import org.springframework.data.repository.CrudRepository;

import com.example.les21.domain.Role;

public interface RoleRepo extends CrudRepository<Role, Long> {
	Role findByName(String name);
}
