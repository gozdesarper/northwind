package com.example.demo.business.response;

import java.util.List;

import com.example.demo.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateCategoryResponse {
	
	private int id;
	private String name;

	

}
