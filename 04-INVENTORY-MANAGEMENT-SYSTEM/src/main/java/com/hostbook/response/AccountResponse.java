package com.hostbook.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountResponse {
	
	private Date timestamp;
	
	private Integer status;
	private String msg;
	//private Integer id;
	

}
