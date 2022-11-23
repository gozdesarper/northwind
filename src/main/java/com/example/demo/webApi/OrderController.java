package com.example.demo.webApi;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.OrderService;
import com.example.demo.business.request.CreateOrderRequest;
import com.example.demo.business.request.DeleteOrderRequest;
import com.example.demo.business.request.UpdateOrderRequest;
import com.example.demo.business.response.DeleteOrderResponse;
import com.example.demo.business.response.GetAllOrderResponse;
import com.example.demo.business.response.UpdateOrderResponse;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
		
	}
	@PostMapping("/add")
	public GetAllOrderResponse add(CreateOrderRequest createOrderRequest) {
		return orderService.add(createOrderRequest);
	}
	@GetMapping("/getAll")
	public List<GetAllOrderResponse> getAllOrderResponses(){
		return orderService.getAllOrderResponses();
	}
	@PostMapping("/update")
	public UpdateOrderResponse update(@RequestBody UpdateOrderRequest updateOrderRequest) {
		return orderService.update(updateOrderRequest);
	}
	@PostMapping("/delete")
	public DeleteOrderResponse delete(@RequestBody DeleteOrderRequest deleteOrderRequest) {
		return orderService.delete(deleteOrderRequest);
	}
}
