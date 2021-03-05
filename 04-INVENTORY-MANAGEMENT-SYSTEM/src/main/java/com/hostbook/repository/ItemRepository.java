package com.hostbook.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hostbook.domain.Item;

public interface ItemRepository extends JpaRepository<Item, Serializable> {
	
	
	

}
