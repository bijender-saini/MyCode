package com.hostbook.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hostbook.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Serializable> {
	
	
	Role findByRole(String role);

}
