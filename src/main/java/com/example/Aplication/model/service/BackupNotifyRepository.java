package com.example.Aplication.model.service;
import com.example.Aplication.model.table.BackupNotify;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface BackupNotifyRepository extends JpaRepository<BackupNotify,Integer> {
}
