package com.powergroup.model.service;

import com.powergroup.model.table.BackupNotify;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface BackupNotifyRepository extends JpaRepository<BackupNotify, Integer> {
    List<BackupNotify> findByUserId(int userId);

    List<BackupNotify> findByMarketId(int marketId);
}
