package com.example.demo.business.response;

import com.example.demo.business.request.CreateEmployeeRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetAllEmployeeResponse {
	
	private int id;
	private String firstName;
	private String lastName;
	private double salary;
	

}
