package com.powergroup.model.service;

import com.powergroup.model.table.PayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface PayRepository extends JpaRepository<PayEntity,Integer> {
    List<PayEntity> findByItemId(int itemId);
    List<PayEntity> findByOrderId(int orderId);
    List<PayEntity> findByUserId(int userId);
    List<PayEntity> findByMarketId(int marketId);
    List<PayEntity> findByStatus(String status);
    List<PayEntity> findByUserIdAndStatus(int userId,String status);
}
