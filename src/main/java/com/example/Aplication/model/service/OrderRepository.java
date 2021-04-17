package com.example.Aplication.model.service;

import com.example.Aplication.model.table.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public interface OrderRepository extends JpaRepository<Order,Integer> {
    Optional<Order> findById(int id);
    List<Order>findByName(String name);
    List<Order>findByUser(int user);
    List<Order>findByCustomer(int customer);
    List<Order>findByStatus(int status);
}
