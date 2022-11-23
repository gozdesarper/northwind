package com.example.demo.webApi;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.EmployeeService;
import com.example.demo.business.request.CreateEmployeeRequest;
import com.example.demo.business.request.DeleteEmployeeRequest;
import com.example.demo.business.request.UpdateEmployeeRequest;
import com.example.demo.business.response.CreateEmployeeResponse;
import com.example.demo.business.response.DeleteEmployeeResponse;
import com.example.demo.business.response.GetAllEmployeeResponse;
import com.example.demo.business.response.GetEmployeeResponse;
import com.example.demo.business.response.UpdateEmployeeResponse;

@RestController // bunun control sınıfı olduğunu belirtiyor.
@RequestMapping("/api/employee") // yolunu belirtiyoruz.

public class EmployeeController {
	private EmployeeService employeeService;
	
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	@GetMapping("/getall")
	public List<GetAllEmployeeResponse> getAllEmployeeResponses() {
		return this.employeeService.getAll();
	}

	@PostMapping("/add")
	public CreateEmployeeResponse add(@RequestBody CreateEmployeeRequest createEmployeeRequest) {
		return employeeService.add(createEmployeeRequest);
		
	}
	@GetMapping("/getbyid")
	public GetEmployeeResponse getById(int id) {
		return employeeService.getById(id);
	}
	@PostMapping("/delete")
	public DeleteEmployeeResponse delete( DeleteEmployeeRequest deleteEmployeeRequest) {
		return this.employeeService.delete(deleteEmployeeRequest);
	}
	@PostMapping("/update")
	public UpdateEmployeeResponse update( UpdateEmployeeRequest updateEmployeeRequest) {
		 return this.employeeService.update(updateEmployeeRequest);
	}
	
}
