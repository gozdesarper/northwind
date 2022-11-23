package com.example.demo.business.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeResponse {
	private int id;
	private String firstName;
	private String lastName;
	private double salary;
	

}
