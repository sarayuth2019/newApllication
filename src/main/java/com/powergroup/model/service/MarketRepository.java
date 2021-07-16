package com.powergroup.model.service;

import com.powergroup.model.table.Market;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface MarketRepository extends JpaRepository<Market, Integer> {
    Market findByEmail(String email);
    Market findByEmailAndPassword(String email, String password);
}
