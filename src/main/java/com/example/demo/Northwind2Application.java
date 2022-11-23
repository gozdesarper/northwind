package com.example.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Northwind2Application {

	public static void main(String[] args) {
		SpringApplication.run(Northwind2Application.class, args);
	}
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
