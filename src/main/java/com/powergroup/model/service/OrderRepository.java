package com.powergroup.model.service;

import com.powergroup.model.table.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findByUserId(int userId);

    List<Order> findByMarketId(int marketId);

    List<Order> findByStatusAndUserId(String status, int userId);

    List<Order> findByStatus(String status);

    List<Order> findByUserIdAndMarketId(int userId,int marketId);

    List<Order> findByItemId(int itemId);
}
