package com.hostbook.domain;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class User extends BaseEntity {
	
	private String firstName;
	private String lastName;
	private String gender;
	private String mobile;
	private String email;
	private String address;
	private String role;
	private boolean status;
	
	

}
