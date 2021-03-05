package com.hostbook.domain;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Item extends BaseEntity{
	
	private String itemName;
	private String itemImage;
	private String itemCategory;
	private String itemQuantity;
	private String itemUnit;
	private String itemUnitPrice;
	private boolean itemStatus;

}
