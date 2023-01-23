package com.example.les21.service;

import org.springframework.stereotype.Repository;

import com.example.les21.domain.User;


@Repository
public interface UserService {
void saveUser(User user);
User findUserByEmail(String email);

}
