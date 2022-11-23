package com.example.demo.webApi;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.CategoryService;
import com.example.demo.business.request.CreateCategoryRequest;
import com.example.demo.business.request.DeleteCategoryRequest;
import com.example.demo.business.request.UpdateCategoryRequest;
import com.example.demo.business.response.CreateCategoryResponse;
import com.example.demo.business.response.DeleteCategoryResponse;
import com.example.demo.business.response.GetAllCategoryResponse;
import com.example.demo.business.response.GetCategoryResponse;
import com.example.demo.business.response.UpdateCategoryResponse;

@RestController
@RequestMapping("/api/categories") 
public class CategoryController {
	private CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@PostMapping("/add")
	public CreateCategoryResponse add(@RequestBody CreateCategoryRequest createCategoryRequest) {
		return categoryService.add(createCategoryRequest);
	}
	@GetMapping("/getall")
	public List<GetAllCategoryResponse> getAllCategoryResponses(){
		return categoryService.getAll();
		}
	@GetMapping("/getbyid")
	public GetCategoryResponse getById(int id) {
		return categoryService.getById(id);
	}
	@PostMapping("/delete")
	public DeleteCategoryResponse delete(DeleteCategoryRequest deleteCategoryRequest) {
		return categoryService.delete(deleteCategoryRequest);
	}
	@PostMapping("/update")
	public UpdateCategoryResponse update(UpdateCategoryRequest deletecategoryRequest) {
		return categoryService.update(deletecategoryRequest);	}
}
