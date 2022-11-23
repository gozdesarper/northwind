package com.example.demo.business.concrate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.ProductService;
import com.example.demo.business.request.CreateProductRequest;
import com.example.demo.business.request.DeleteProductRequest;
import com.example.demo.business.request.UpdateProductRequest;
import com.example.demo.business.response.CreateProductResponse;
import com.example.demo.business.response.DeleteProductResponse;
import com.example.demo.business.response.GetAllProductsResponse;
import com.example.demo.business.response.GetProductResponse;
import com.example.demo.business.response.UpdateProductResponse;
import com.example.demo.core.utilities.mapping.ModelMapperService;
import com.example.demo.dataAccess.abstracts.ProductRepository;
import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
@Service
public class ProductManager implements ProductService{
	
	private ProductRepository productRepository;
	
	private ModelMapperService modelMapperService;

	public ProductManager(ProductRepository productRepository) {
	
		this.productRepository = productRepository;
	}

	@Override
	public CreateProductResponse add(CreateProductRequest createProductRequest) {
		Product product = this.modelMapperService.forRequest().map(createProductRequest,Product.class);
		this.productRepository.save(product);
		
		productRepository.save(product);
		
		CreateProductResponse createProductResponse = modelMapperService.forResponse().map(product , CreateProductResponse.class);
		
		
		return createProductResponse;
	}

	@Override
	public List<GetAllProductsResponse> getAllProductResponses() {
		
	 List<GetAllProductsResponse> getAllProductsResponses = new ArrayList<GetAllProductsResponse>();
	 
	 List<Product> products = this.productRepository.findAll(); //veri tabanındaki tüm bilgiler Product tutuluyor products'a çekiliyor.
	 
	 for (Product product : products) {
		 
		GetAllProductsResponse getAllProductsResponse = new GetAllProductsResponse();
		
		getAllProductsResponse.setId(product.getId());
		getAllProductsResponse.setName(product.getName());
		getAllProductsResponse.setUnitPrice(product.getUnitPrice());
		getAllProductsResponse.setUnitsInStock(product.getUnitsInStock());
		getAllProductsResponse.setCategoryName(product.getCategory().getName());
		getAllProductsResponses.add(getAllProductsResponse);
	}
			
		return getAllProductsResponses;
	}

	@Override
	public List<GetAllProductsResponse> getByName(String name) {
	
		List<GetAllProductsResponse> getAllProductsResponses=new ArrayList<GetAllProductsResponse>();
		
		List<Product> getAllByNameProducts=productRepository.findByName(name);
		for (Product product : getAllByNameProducts) {
			GetAllProductsResponse getAllProductsResponse=new GetAllProductsResponse();
			getAllProductsResponse.setId(product.getId());
			getAllProductsResponse.setName(product.getName());
			getAllProductsResponse.setCategoryName(product.getCategory().getName());
			getAllProductsResponse.setUnitPrice(product.getUnitPrice());
			getAllProductsResponse.setUnitsInStock(product.getUnitsInStock());
			getAllProductsResponses.add(getAllProductsResponse);
		}
		return getAllProductsResponses;
		
	}

	@Override
	public GetProductResponse getById(int id) {
		Product product = productRepository.findById(id).orElseThrow(); // girirlen id ye göre producthları getir. orelsethrow girilen id yok ise hata ver.
		GetProductResponse productResponse = new GetProductResponse();
		productResponse.setId(product.getId());
		productResponse.setName(product.getName());
		productResponse.setUnitPrice(product.getUnitPrice());
		productResponse.setUnitInStock(product.getUnitsInStock());
		productResponse.setCategoryName(product.getCategory().getName());
		
		return productResponse;
	}

	@Override
	public UpdateProductResponse update(UpdateProductRequest updateProductRequest) {
		UpdateProductResponse productResponse = new UpdateProductResponse();
		Product product = productRepository.findById(updateProductRequest.getId()).get();
		product.setName(updateProductRequest.getName());
		product.setUnitPrice(updateProductRequest.getUnitPrice());
		product.setUnitsInStock(updateProductRequest.getUnitsInStock());
		Category category = new Category();
		
		category.setId(updateProductRequest.getCategoryId());
		product.setCategory(category);
		
		productRepository.save(product);
		productResponse.setName(product.getName());
		productResponse.setUnitPrice(product.getUnitPrice());
		productResponse.setUnitInStock(product.getUnitsInStock());
		productResponse.setId(product.getId());
		productResponse.setCategoryName(category.getName());
		return productResponse;
	}

	@Override
	public DeleteProductResponse delete(DeleteProductRequest deleteProductRequest) {
		DeleteProductResponse productResponse = new DeleteProductResponse();
		Product product = productRepository.findById(deleteProductRequest.getId()).get();
		productRepository.delete(product);
		productResponse.setId(product.getId());
		productResponse.setName(product.getName());
		productResponse.setUnitPrice(product.getUnitPrice());
		productResponse.setUnitInStock(product.getUnitsInStock());
		
		return productResponse;
	}
	

	

	

}
