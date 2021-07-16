package com.powergroup.model.service;

import com.powergroup.model.table.Notify;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface NotifyRepository extends JpaRepository<Notify, Integer> {
    List<Notify> findByUserId(int userId);
    List<Notify> findByMarketId(int marketId);
    int deleteByUserId(int userId);
    int deleteByMarketId(int marketId);
}
