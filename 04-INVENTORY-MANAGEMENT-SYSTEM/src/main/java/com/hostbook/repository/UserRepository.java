package com.hostbook.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hostbook.domain.User;

public interface UserRepository extends JpaRepository<User, Serializable> {

	
	User findByMobile(String mobile);
	User findByEmail(String email);
	User findByRoleIgnoreCase(String role);
	
}
