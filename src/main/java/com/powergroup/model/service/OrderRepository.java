package com.powergroup.model.service;

import com.powergroup.model.table.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByNameOrder(String nameOrder);

    List<Order> findByUserId(int userId);

    List<Order> findByMarketId(int marketId);

    List<Order> findByStatusAndUserId(int status, int userId);
}
