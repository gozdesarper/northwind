package com.example.demo.business.concrate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.OrderService;
import com.example.demo.business.request.CreateOrderRequest;
import com.example.demo.business.request.DeleteOrderRequest;
import com.example.demo.business.request.UpdateOrderRequest;
import com.example.demo.business.response.DeleteOrderResponse;
import com.example.demo.business.response.GetAllOrderResponse;
import com.example.demo.business.response.UpdateOrderResponse;
import com.example.demo.dataAccess.abstracts.OrderRepository;
import com.example.demo.entities.Employee;
import com.example.demo.entities.Order;
@Service
public class OrderManager implements OrderService {
	OrderRepository orderRepository;
	EmployeeManager employeeManager;
	
	public OrderManager(OrderRepository orderRepository,EmployeeManager employeeManager) {
		this.orderRepository = orderRepository;
		this.employeeManager=employeeManager;
	}

	@Override
	public GetAllOrderResponse add(CreateOrderRequest createOrderRequest) {
		GetAllOrderResponse getAllOrderResponse = new GetAllOrderResponse();
		
		Order order = new Order();
		
		Employee employee = new Employee();
		employee.setId(createOrderRequest.getEmployeeId());//buradan creat...den employee atadık employee de ordera gönderdik.
		order.setEmployee(employee); //order'a istediği id yi verdik.
		
		orderRepository.save(order);
		
		getAllOrderResponse.setId(order.getId());
		getAllOrderResponse.setDate(order.getDate());
		getAllOrderResponse.setEmployeId(order.getEmployee().getId());
		getAllOrderResponse.setFirstName(order.getEmployee().getFirstName());
		
		return getAllOrderResponse;
		
	}
	@Override
	public List<GetAllOrderResponse> getAllOrderResponses() {
	List<GetAllOrderResponse> getAllOrderResponses = new ArrayList<>();
	List<Order> orders  = orderRepository.findAll();
	
	for (Order order : orders) {
		GetAllOrderResponse getAllOrderResponse = new GetAllOrderResponse();
		getAllOrderResponse.setId(order.getId());
		getAllOrderResponse.setDate(order.getDate());
		getAllOrderResponse.setEmployeId(order.getEmployee().getId());
		getAllOrderResponse.setFirstName(order.getEmployee().getFirstName());
		
		getAllOrderResponses.add(getAllOrderResponse);
	}
		
		return getAllOrderResponses;
	}

	@Override
	public UpdateOrderResponse update(UpdateOrderRequest updateOrderRequest) {
		UpdateOrderResponse updateOrderResponse = new UpdateOrderResponse();
		Order order = orderRepository.findById(updateOrderRequest.getId()).get();
		
		Employee employee = new Employee();
		employee.setId(updateOrderRequest.getId());
		order.setEmployee(employee);
		
		updateOrderResponse.setEmployeeId(order.getEmployee().getId());
		updateOrderResponse.setId(order.getId());
		return updateOrderResponse;
	}

	@Override
	public DeleteOrderResponse delete(DeleteOrderRequest deleteOrderRequest) {
		DeleteOrderResponse deleteOrderResponse = new DeleteOrderResponse();
		Order order = orderRepository.findById(deleteOrderRequest.getId()).get();
		orderRepository.delete(order);
		deleteOrderResponse.setId(order.getId());
		deleteOrderResponse.setDate(order.getDate());
		deleteOrderResponse.setEmployeId(order.getEmployee().getId());
		return deleteOrderResponse;
	}

}
