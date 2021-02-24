package com.example.Aplication.model.service;

import com.example.Aplication.model.table.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
