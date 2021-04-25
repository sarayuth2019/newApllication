package com.example.Aplication.model.service;
import com.example.Aplication.model.table.BackupNotify;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface BackupNotifyRepository extends JpaRepository<BackupNotify,Integer> {
    List<BackupNotify> findByUser(int user);
    List<BackupNotify> findByCustomer(int customer);
    List<BackupNotify> findByUserAndCustomer(int user,int customer);
}
