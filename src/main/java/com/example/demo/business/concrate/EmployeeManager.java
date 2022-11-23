package com.example.demo.business.concrate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.EmployeeService;
import com.example.demo.business.request.CreateEmployeeRequest;
import com.example.demo.business.request.DeleteEmployeeRequest;
import com.example.demo.business.request.UpdateEmployeeRequest;
import com.example.demo.business.response.CreateEmployeeResponse;
import com.example.demo.business.response.DeleteEmployeeResponse;
import com.example.demo.business.response.GetAllEmployeeResponse;
import com.example.demo.business.response.GetEmployeeResponse;
import com.example.demo.business.response.UpdateEmployeeResponse;
import com.example.demo.dataAccess.abstracts.EmployeeRepository;
import com.example.demo.entities.Employee;
@Service
public class EmployeeManager implements EmployeeService{
	
	EmployeeRepository employeeRepesitory;

	public EmployeeManager(EmployeeRepository employeeRepesitory) {
		this.employeeRepesitory = employeeRepesitory;
	}

	@Override
	public CreateEmployeeResponse add(CreateEmployeeRequest createEmployeeRequest) {
		CreateEmployeeResponse createEmployeeResponse = new CreateEmployeeResponse();
		Employee employee = new Employee();
		
		employee.setFirstName(createEmployeeRequest.getFirstName());
		employee.setLastName(createEmployeeRequest.getLastName());
		employee.setSalary(createEmployeeRequest.getSalary());
		employeeRepesitory.save(employee);
		
		createEmployeeResponse.setId(employee.getId());
		createEmployeeResponse.setFirstName(createEmployeeRequest.getFirstName());
		createEmployeeResponse.setLastName(createEmployeeRequest.getLastName());
		createEmployeeResponse.setSalary(createEmployeeRequest.getSalary());
		
		return createEmployeeResponse;
	}

	@Override
	public List<GetAllEmployeeResponse> getAll() {
		List<GetAllEmployeeResponse> employeesResponse = new ArrayList<GetAllEmployeeResponse>();
		List<Employee> employees = this.employeeRepesitory.findAll();
		
		for (Employee employee : employees) {
			GetAllEmployeeResponse responseItem = new GetAllEmployeeResponse();
			responseItem.setId(employee.getId());
			responseItem.setFirstName(employee.getFirstName());
			responseItem.setLastName(employee.getLastName());
			responseItem.setSalary(employee.getSalary());
			
			
			employeesResponse.add(responseItem);
		}
		return employeesResponse;
	}

	@Override
	public GetEmployeeResponse getById(int id) {
		GetEmployeeResponse employeeResponse = new GetEmployeeResponse();
		Employee employee = employeeRepesitory.findById(id).get();
		employeeResponse.setId(employee.getId());
		employeeResponse.setFirstName(employee.getFirstName());
		employeeResponse.setLastName(employee.getLastName());
		employeeResponse.setSalary(employee.getSalary());
		
		return employeeResponse;
	}

	@Override
	public DeleteEmployeeResponse delete(DeleteEmployeeRequest deleteEmployeeRequest) {
		DeleteEmployeeResponse deleteEmployeeResponse = new DeleteEmployeeResponse();
		Employee employee = employeeRepesitory.findById(deleteEmployeeRequest.getId()).get();
		employeeRepesitory.delete(employee);
		deleteEmployeeResponse.setId(employee.getId());
		deleteEmployeeResponse.setFirstName(employee.getFirstName());
		deleteEmployeeResponse.setLastName(employee.getLastName());
		deleteEmployeeResponse.setSalary(employee.getSalary());
		
		return deleteEmployeeResponse;
	}

	@Override
	public UpdateEmployeeResponse update(UpdateEmployeeRequest updateEmployeeRequest) {
		UpdateEmployeeResponse updateEmployeeResponse = new UpdateEmployeeResponse();
		Employee employee = employeeRepesitory.findById(updateEmployeeRequest.getId()).get();
		employee.setFirstName(updateEmployeeRequest.getFirstName());
		employee.setLastName(updateEmployeeRequest.getLastName());
		employee.setSalary(updateEmployeeRequest.getSalary());
		
		employeeRepesitory.save(employee);
		updateEmployeeResponse.setFirstName(updateEmployeeRequest.getFirstName());
		updateEmployeeResponse.setLastName(updateEmployeeRequest.getLastName());
		updateEmployeeResponse.setSalary(updateEmployeeRequest.getSalary());
		updateEmployeeResponse.setId(updateEmployeeRequest.getId());
		
	
		return updateEmployeeResponse;
	}



 
}
