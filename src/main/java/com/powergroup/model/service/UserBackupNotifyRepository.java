package com.powergroup.model.service;

import com.powergroup.model.table.UserBackupNotify;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface UserBackupNotifyRepository extends JpaRepository<UserBackupNotify, Integer> {
    List<UserBackupNotify> findByUserId(int userId);

}
