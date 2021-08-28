package com.powergroup.model.service;

import com.powergroup.model.table.UserNotify;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface UserNotifyRepository extends JpaRepository<UserNotify, Integer> {
    List<UserNotify> findByUserId(int userId);
    int deleteByUserId(int userId);
}
