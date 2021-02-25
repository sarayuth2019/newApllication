package com.example.Aplication.model.service;

import com.example.Aplication.model.table.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;


public interface OrderRepository extends JpaRepository<Order,Integer> {
    Optional<Order> findById(int id);
    List<Order>findByName(String name);
    List<Order>findByUser(int user);
}
