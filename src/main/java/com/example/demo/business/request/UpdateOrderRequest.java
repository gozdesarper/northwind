package com.example.demo.business.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateOrderRequest {
	
	private int id;
	private int employeeId;
	private LocalDate date = LocalDate.now();

}
