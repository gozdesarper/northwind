package com.example.demo.core.utilities.mapping;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

public interface ModelMapperService {


	ModelMapper forRequest();
	ModelMapper forResponse();
}

		
	
