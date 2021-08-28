package com.powergroup.model.service;

import com.powergroup.model.table.MarketNotify;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface MarketNotifyRepository extends JpaRepository<MarketNotify,Integer> {
    int deleteByMarketId(int marketId);
    List<MarketNotify> findByMarketId(int userId);
}
