package com.example.demo.business.response;

import com.example.demo.entities.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetAllProductsResponse {

	private int id;
	private String name;
	private double unitPrice;
	private int UnitsInStock; 
	private String categoryName;
}