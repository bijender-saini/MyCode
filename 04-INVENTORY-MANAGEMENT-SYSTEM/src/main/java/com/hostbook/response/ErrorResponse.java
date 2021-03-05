package com.hostbook.response;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {

	

	private Date timestamp;
	private  Integer erorcode;
	private List<String> msg;
}
