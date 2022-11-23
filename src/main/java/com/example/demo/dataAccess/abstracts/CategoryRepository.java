package com.example.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	Category findById(int id);

}
