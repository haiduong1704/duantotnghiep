package com.fpoly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fpoly.entity.Users;

@Repository
public interface UsersRepo extends JpaRepository<Users, Long>{
		Users findByUsername(String username);
		Users findByUsernameAndHashPassword(String username, String password);
}
