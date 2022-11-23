package com.example.demo.business.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductResponse {

	private int id;
	private String name;
	private double unitPrice;
	private int unitsInStock; 
	private String categoryName;
}

