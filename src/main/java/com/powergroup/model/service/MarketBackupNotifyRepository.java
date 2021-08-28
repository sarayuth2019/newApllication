package com.powergroup.model.service;

import com.powergroup.model.table.MarketBackupNotify;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface MarketBackupNotifyRepository extends JpaRepository<MarketBackupNotify,Integer> {
    List<MarketBackupNotify> findByMarketId(int marketId);
}
