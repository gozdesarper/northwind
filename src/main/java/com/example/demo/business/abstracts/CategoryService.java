package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.business.request.CreateCategoryRequest;
import com.example.demo.business.request.DeleteCategoryRequest;
import com.example.demo.business.request.UpdateCategoryRequest;
import com.example.demo.business.response.CreateCategoryResponse;
import com.example.demo.business.response.DeleteCategoryResponse;
import com.example.demo.business.response.GetAllCategoryResponse;
import com.example.demo.business.response.GetCategoryResponse;
import com.example.demo.business.response.UpdateCategoryResponse;

public interface CategoryService {

	CreateCategoryResponse add(CreateCategoryRequest createCategoryRequest) ;
	List<GetAllCategoryResponse> getAll();
	GetCategoryResponse getById(int id);
	DeleteCategoryResponse delete(DeleteCategoryRequest deleteCategoryRequest);
	UpdateCategoryResponse update(UpdateCategoryRequest deletecategoryRequest);
	
	
}
