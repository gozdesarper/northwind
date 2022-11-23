package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.business.request.CreateEmployeeRequest;
import com.example.demo.business.request.DeleteEmployeeRequest;
import com.example.demo.business.request.UpdateEmployeeRequest;
import com.example.demo.business.response.CreateEmployeeResponse;
import com.example.demo.business.response.DeleteEmployeeResponse;
import com.example.demo.business.response.GetAllEmployeeResponse;
import com.example.demo.business.response.GetEmployeeResponse;
import com.example.demo.business.response.UpdateEmployeeResponse;

public interface EmployeeService {
	CreateEmployeeResponse add(CreateEmployeeRequest createEmployeeRequest);
	List<GetAllEmployeeResponse> getAll();
	GetEmployeeResponse getById(int id);//bana bir tane ıd ver bu ıd ye karşılık gelen kişiyi döndür.
	DeleteEmployeeResponse delete(DeleteEmployeeRequest deleteEmployeeRequest);
	UpdateEmployeeResponse update(UpdateEmployeeRequest updateEmpleyeeRequest);
	
	

}

