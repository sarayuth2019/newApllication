package com.powergroup.model.service;

import com.powergroup.model.table.PaymentAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface PayAdminRepository extends JpaRepository<PaymentAdmin,Integer> {
    //    List<PayEntity> findByItemId(int itemId);
    List<PaymentAdmin> findByPayId(int payId);
    List<PaymentAdmin> findByAdminId(int adminId);
    List<PaymentAdmin> findByItemId(int itemId);
    List<PaymentAdmin> findByMarketId(int marketId);
    List<PaymentAdmin> findByStatus(String status);
    List<PaymentAdmin> findByStatusAndMarketId(String status,int marketId);
}
