package com.hostbook.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hostbook.domain.Item;
import com.hostbook.dto.ItemDTO;

import com.hostbook.response.ItemResponse;
import com.hostbook.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService service;

	@PostMapping("/item")
	ResponseEntity<ItemResponse> saveItem(@RequestBody @Valid ItemDTO itemDTO) {

		service.getItem(itemDTO);

		ItemResponse item = new ItemResponse(new Date(), 200, "Item Add  in Stock");

		return new ResponseEntity<>(item, HttpStatus.CREATED);
	}

	@GetMapping("getItem")
	List<Item> getAllItem(@RequestBody ItemDTO itemDTO) {
		return service.getAllItem();

	}

	@DeleteMapping("/deleteItem")
	ResponseEntity<String> deleteItem(@PathVariable("id") Long id, @RequestBody ItemDTO itemDTO)

	{

		service.updateItem(id, itemDTO);
		return new ResponseEntity<String>("Item Deleted Successfully", HttpStatus.OK);
	}
}
