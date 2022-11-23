package com.example.demo.business.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateEmployeeRequest {
 private String firstName;
 private String lastName;
 private double salary;
}
