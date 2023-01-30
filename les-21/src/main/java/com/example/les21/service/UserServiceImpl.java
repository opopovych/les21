package com.example.les21.service;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.les21.daoRepo.RoleRepo;
import com.example.les21.daoRepo.UserRepo;
import com.example.les21.domain.Role;
import com.example.les21.domain.User;
@Service
public class UserServiceImpl implements UserService {
	
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserRepo userRepo;
	private RoleRepo roleRepo;
	private PasswordEncoder passwordEncoder;
	
	

	public UserServiceImpl(UserRepo userRepo, RoleRepo roleRepo, PasswordEncoder passwordEncoder) {
		super();
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void saveUser(User user) {
		logger.info("Create new user");
		User user1 = new User();
		user1.setFirstName(user.getFirstName());
		user1.setLastName(user.getLastName());
		user1.setEmail(user.getEmail());
		user1.setPassword(passwordEncoder.encode(user.getPassword()));
		Role role = roleRepo.findByName("");
		if (role == null) {
			role = checkRoleExist();
		}
		user1.setRoles(Arrays.asList(role));
		userRepo.save(user1);
	}

	@Override
	public User findUserByEmail(String email) {
logger.info("Get user by email - " + email);
		return userRepo.findByEmail(email);
	}

	private Role checkRoleExist() {
		
		Role role = new Role();
		role.setName("ROLE_ADMIN");
		roleRepo.save(role);
		return role;
	}
}
