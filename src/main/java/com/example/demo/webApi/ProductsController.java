package com.example.demo.webApi;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.ProductService;
import com.example.demo.business.request.CreateProductRequest;
import com.example.demo.business.request.DeleteProductRequest;
import com.example.demo.business.request.UpdateProductRequest;
import com.example.demo.business.response.CreateProductResponse;
import com.example.demo.business.response.DeleteProductResponse;
import com.example.demo.business.response.GetAllProductsResponse;
import com.example.demo.business.response.GetProductResponse;
import com.example.demo.business.response.UpdateProductResponse;

@RestController
@RequestMapping("/api/product")
public class ProductsController {

	private ProductService productService;
	
	
	public ProductsController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping("/add")
	public CreateProductResponse add(@RequestBody CreateProductRequest createProductRequest) {
	
		return this.productService.add(createProductRequest);
	
	}
	@GetMapping("/getAll")
	public List<GetAllProductsResponse> getAllProductsResponses(){
		return this.productService.getAllProductResponses();
		
	}
	
	@GetMapping("/getAllByName/{name}")
	public List<GetAllProductsResponse> getByName(@PathVariable(name = "name") String name){
	
		return this.productService.getByName(name);
	}
	@GetMapping("/getById/{id}")
	public 	GetProductResponse getById(@PathVariable(name = "id") int id) {
		
		return this.productService.getById(id);
	}
	@PostMapping("/update")
	public UpdateProductResponse update(UpdateProductRequest updateProductRequest) {
		return this.productService.update(updateProductRequest);
		}
	@PostMapping("/delete")
	public DeleteProductResponse delete(DeleteProductRequest deleteProductRequest) {
		return this.productService.delete(deleteProductRequest);
	}
}
