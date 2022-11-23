package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.business.request.CreateOrderRequest;
import com.example.demo.business.request.DeleteOrderRequest;
import com.example.demo.business.request.UpdateOrderRequest;
import com.example.demo.business.response.DeleteOrderResponse;
import com.example.demo.business.response.GetAllOrderResponse;
import com.example.demo.business.response.UpdateOrderResponse;

public interface OrderService{
	
	GetAllOrderResponse add(CreateOrderRequest createOrderRequest) ;
	List<GetAllOrderResponse> getAllOrderResponses ();
	UpdateOrderResponse update(UpdateOrderRequest updateOrderRequest);
	DeleteOrderResponse delete(DeleteOrderRequest deleteOrderRequest);
	
	
			
		
	

}
