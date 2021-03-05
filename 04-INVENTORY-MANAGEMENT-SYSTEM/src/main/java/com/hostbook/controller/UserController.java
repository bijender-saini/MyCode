package com.hostbook.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hostbook.dto.UserDTO;
import com.hostbook.response.AccountResponse;
import com.hostbook.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/user")
	ResponseEntity<AccountResponse> createAccount(@RequestBody @Valid UserDTO userDTO) {
		userService.createUserAccount(userDTO);
		AccountResponse accountResponse = new AccountResponse(new Date(), 200, "your Account Created Successfully");

		return new ResponseEntity<>(accountResponse, HttpStatus.CREATED);
	}

	@PutMapping("/user/{id}")
	ResponseEntity<AccountResponse> updateUserAccount(@PathVariable("id") Long id, @RequestBody UserDTO userDTO)

	{

		userService.updateUserAccount(id, userDTO);

		AccountResponse accountResponse = new AccountResponse(new Date(), 200, "your Account Updated Successfully");

		return new ResponseEntity<>(accountResponse, HttpStatus.CREATED);
	}

}
