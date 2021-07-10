package com.example.Aplication.model.service;

import com.example.Aplication.model.table.Notify;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface NotifyRepository extends JpaRepository<Notify,Integer> {
    List<Notify> findByUserId(int userId);
    List<Notify> findByCustomerId(int customerId);
    int deleteByUserId(int userId);
    int deleteByCustomerId(int customerId);
}
