package com.example.demo.business.response;

import java.time.LocalDate;

import com.example.demo.business.request.DeleteOrderRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteOrderResponse {
	
	private int id;
	private int employeId;
	private LocalDate date = LocalDate.now();

}
