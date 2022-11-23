package com.example.demo.business.request;

import com.example.demo.business.response.DeleteCategoryResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryRequest {
	
	private int id;
	private String name;
	

}
