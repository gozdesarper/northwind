package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.business.request.CreateEmployeeRequest;
import com.example.demo.business.request.CreateProductRequest;
import com.example.demo.business.request.DeleteProductRequest;
import com.example.demo.business.request.UpdateProductRequest;
import com.example.demo.business.response.CreateProductResponse;
import com.example.demo.business.response.DeleteProductResponse;
import com.example.demo.business.response.GetAllOrderResponse;
import com.example.demo.business.response.GetAllProductsResponse;
import com.example.demo.business.response.GetProductResponse;
import com.example.demo.business.response.UpdateCategoryResponse;
import com.example.demo.business.response.UpdateProductResponse;

public interface ProductService {

	
	List<GetAllProductsResponse> getAllProductResponses();
	CreateProductResponse add(CreateProductRequest creatProductRequest);
	List<GetAllProductsResponse> getByName(String name);
	GetProductResponse getById(int id); //ıd'si verilen product'ı döndürürü.
	UpdateProductResponse update(UpdateProductRequest updateProductRequest);
	DeleteProductResponse delete(DeleteProductRequest deleteProductRequest);
	
	
	
}
