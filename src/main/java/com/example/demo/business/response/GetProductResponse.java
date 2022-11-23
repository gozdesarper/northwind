package com.example.demo.business.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetProductResponse {
	
	private int id;
	private String name;
	private double unitPrice;
	private int unitInStock;
	private String categoryName;

}
