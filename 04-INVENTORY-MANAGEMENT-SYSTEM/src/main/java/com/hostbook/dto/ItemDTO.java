package com.hostbook.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class ItemDTO {

	@NotEmpty(message = "Name must not be empty")
	private String itemName;

	private String itemImage;
	@NotEmpty(message = "category must not be empty")
	private String itemCategory;
	@NotEmpty(message = "Qty must not be empty")

	private String itemQuantity;
	@NotEmpty(message = "Unit must not be empty")

	private String itemUnit;
	@NotEmpty(message = "Price must not be empty")

	private String itemUnitPrice;

}
