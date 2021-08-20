package com.powergroup.model.service;

import com.powergroup.model.table.Cart;
import org.springframework.data.jpa.repository.JpaRepository;


import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findByNameCart(String nameCart);

    List<Cart> findByUserId(int userId);

    List<Cart> findByMarketId(int marketId);

    List<Cart> findByStatus(String status);
}




