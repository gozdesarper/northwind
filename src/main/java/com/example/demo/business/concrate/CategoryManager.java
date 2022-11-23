package com.example.demo.business.concrate;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.CategoryService;
import com.example.demo.business.request.CreateCategoryRequest;
import com.example.demo.business.request.DeleteCategoryRequest;
import com.example.demo.business.request.UpdateCategoryRequest;
import com.example.demo.business.response.CreateCategoryResponse;
import com.example.demo.business.response.DeleteCategoryResponse;
import com.example.demo.business.response.GetAllCategoryResponse;
import com.example.demo.business.response.GetCategoryResponse;
import com.example.demo.business.response.UpdateCategoryResponse;
import com.example.demo.core.utilities.mapping.ModelMapperService;
import com.example.demo.dataAccess.abstracts.CategoryRepository;
import com.example.demo.entities.Category;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService{

	private CategoryRepository categoryRepository;
	private ModelMapperService modelMapperService;
	@Override
	public CreateCategoryResponse add(CreateCategoryRequest createCategoryRequest) {
		Category category = this.modelMapperService.forRequest().map(createCategoryRequest, Category.class);
		categoryRepository.save(category);
		CreateCategoryResponse createCategoryResponse = this.modelMapperService.forResponse().map(category, CreateCategoryResponse.class);
		return createCategoryResponse;
	}

	@Override
	public List<GetAllCategoryResponse> getAll(){
		List<GetAllCategoryResponse> getAllCategoryResponses = new ArrayList<GetAllCategoryResponse>();
		List<Category> categories = categoryRepository.findAll();
		
		for (Category category : categories) {
			GetAllCategoryResponse responseItem = new GetAllCategoryResponse();
			responseItem.setId(category.getId());
			responseItem.setName(category.getName());
			getAllCategoryResponses.add(responseItem);
			
		}
		return getAllCategoryResponses;
	}

	@Override
	public GetCategoryResponse getById(int id) {
		GetCategoryResponse categoryResponse = new GetCategoryResponse();
		Category category =  this.categoryRepository.findById(id);
		categoryResponse.setId(category.getId());
		categoryResponse.setName(category.getName());
		return categoryResponse;
		
	}

	@Override
	public DeleteCategoryResponse delete(DeleteCategoryRequest deleteCategoryRequest) {
		DeleteCategoryResponse deleteCategoryResponse = new DeleteCategoryResponse();
		Category category = categoryRepository.findById(deleteCategoryRequest.getId());
		categoryRepository.delete(category);
		deleteCategoryResponse.setId(category.getId());
		deleteCategoryResponse.setName(category.getName());
		return deleteCategoryResponse;
	}

	@Override
	public UpdateCategoryResponse update(UpdateCategoryRequest updatecategoryRequest) {
		Category category = this.modelMapperService.forRequest().map(updatecategoryRequest, Category.class);
			categoryRepository.save(category);
		UpdateCategoryResponse updateCategoryResponse = this.modelMapperService.forResponse().map(category, UpdateCategoryResponse.class);
			
		return updateCategoryResponse;
	}

	

}
