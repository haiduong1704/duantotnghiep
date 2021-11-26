package com.fpoly.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fpoly.entity.Users;
@Service
public interface UsersSevice {
	List<Users> findAll();
	Users findByUsername(String username);
	Users findById(Long id);
    Users doLogin(String username, String password);
    Users save(Users user);
}
