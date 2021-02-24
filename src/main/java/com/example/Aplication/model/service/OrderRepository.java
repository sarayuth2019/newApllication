package com.example.Aplication.model.service;

import com.example.Aplication.model.table.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    Optional<Order> findById(int id);
}
