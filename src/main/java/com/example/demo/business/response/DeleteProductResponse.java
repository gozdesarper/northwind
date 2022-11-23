package com.example.demo.business.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DeleteProductResponse {
	
	private int id;
	private String name;
	private double UnitPrice;
	private int unitInStock;

}
