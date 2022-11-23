package com.example.demo.business.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetAllOrderResponse {
	
	private int id;
	private LocalDate date =LocalDate.now();
    private int employeId;
    private String firstName;
 }
