package com.example.demo.business.response;

import com.example.demo.business.request.UpdateProductRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductResponse {
	
	private int id;
	private String name;
	private double unitPrice;
	private int unitInStock;
	private String categoryName;

}
