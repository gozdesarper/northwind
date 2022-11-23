package com.example.demo.business.request;

import com.example.demo.business.response.DeleteProductResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteProductRequest {
	
	private int id;

}
