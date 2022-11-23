package com.example.demo.business.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateProductRequest {
	
	
	private int id;
	private String name;
	private double unitPrice;
	private int unitsInStock;
	private int categoryId;
	

}
