package com.example.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
