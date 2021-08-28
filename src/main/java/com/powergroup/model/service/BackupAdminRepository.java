package com.powergroup.model.service;

import com.powergroup.model.table.BackupAdminNotify;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BackupAdminRepository extends JpaRepository<BackupAdminNotify,Integer> {
}
