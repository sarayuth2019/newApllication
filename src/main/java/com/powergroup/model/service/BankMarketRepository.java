package com.powergroup.model.service;

import com.powergroup.model.table.BankMarket;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface BankMarketRepository extends JpaRepository<BankMarket,Integer> {
    List<BankMarket> findByMarketId(int marketId);
}
