package com.fpoly.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.fpoly.entity.Users;
import com.fpoly.repository.UsersRepo;
import com.fpoly.service.UsersSevice;

@Service
public class UsersServiceImpl implements UsersSevice{
	@Autowired 
	private UsersRepo repo;

	@Override
	public Users doLogin(String username, String password) {
		Users user = repo.findByUsername(username);
		if(ObjectUtils.isEmpty(user))
		{
			return null; //sai
		}
		else 
		{
			//check tiep password
			BCryptPasswordEncoder bcrypt =new BCryptPasswordEncoder();
		 boolean checkpassword =	bcrypt.matches(password,user.getHashPassword());
		 
		 // checkpassword 
		 if (checkpassword) 
		 {
			return user;
		 }
		 else 
		 {
			 return null;
		 }
		}
	}

	@Override
	public List<Users> findAll() {
		return repo.findAll();
	}

	@Override
	public Users findByUsername(String username) {
		return repo.findByUsername(username);
	}

	@Override
	public Users findById(Long id) {
		Optional<Users> result = repo.findById(id);
		return result.isPresent() ? result.get() : null;
	}

	@Override
	public Users save(Users user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
